package com.stackroute.accountmanager.service;


import com.stackroute.accountmanager.model.UserAccount;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtSecurityTockengeneratorImpl implements  SecurityTokenGenerator {
    @Override
    public Map<String, String> generateToken(UserAccount user) {
        String jwtToken = null;
        jwtToken = Jwts.builder().setSubject(user.getUserName()).setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256 ,"secretkey").compact();
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", jwtToken);
        tokenMap.put("message", "user successfully logged in");
        return tokenMap;
    }
}
