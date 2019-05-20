package com.stackroute.accountmanager.service;

import com.stackroute.accountmanager.exception.UserNotFoundException;
import com.stackroute.accountmanager.model.UserAccount;
import com.stackroute.accountmanager.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public UserAccount findByUserNameAndPassword(String userName, String password) throws UserNotFoundException {
        UserAccount user = userAccountRepository.findByUserNameAndPassword(userName, password);
        if(user == null){
            throw new UserNotFoundException();
        }

        return user;
    }

    @Override
    public UserAccount saveUser(UserAccount user) {
        return userAccountRepository.save(user);
    }
}
