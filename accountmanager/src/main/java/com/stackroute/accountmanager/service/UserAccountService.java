package com.stackroute.accountmanager.service;

import com.stackroute.accountmanager.exception.UserNotFoundException;
import com.stackroute.accountmanager.model.UserAccount;


public interface UserAccountService {

    public UserAccount findByUserNameAndPassword(String userName, String password) throws UserNotFoundException;
    public UserAccount saveUser(UserAccount user) ;
}
