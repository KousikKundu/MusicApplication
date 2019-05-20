package com.example.orchestrationservice.service;

import com.example.orchestrationservice.domain.User;
import com.example.orchestrationservice.exception.UserAlreadyExistsException;

public interface OrchestrationService {

    User registerUser(User user) throws UserAlreadyExistsException;
}
