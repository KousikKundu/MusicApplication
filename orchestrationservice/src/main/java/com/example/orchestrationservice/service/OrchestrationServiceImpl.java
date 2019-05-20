package com.example.orchestrationservice.service;

import com.example.orchestrationservice.domain.User;
import com.example.orchestrationservice.exception.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrchestrationServiceImpl implements OrchestrationService {

    @Autowired
    RestTemplate restTemplate;

    String urlUserTrackService = "http://usertrackservice/api/usertrackservice/register";
    String urlUserAthenticateService = "http://authenticationservice/api/userservice/save";

    @Override
    public User registerUser(User user) throws UserAlreadyExistsException {
        User userResponse = null;

        try {

            userResponse =  restTemplate.postForObject(urlUserTrackService,user,User.class);

            restTemplate.postForObject(urlUserAthenticateService,user,User.class);

        }catch(Exception e){

            throw new UserAlreadyExistsException();
        }

        return userResponse;
    }
}
