package com.stackroute.accountmanager.service;

import com.stackroute.accountmanager.model.UserAccount;


import java.util.Map;

public interface SecurityTokenGenerator {

  Map<String, String> generateToken(UserAccount user);
}
