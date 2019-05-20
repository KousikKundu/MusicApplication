package com.example.orchestrationservice.controller;

import com.example.orchestrationservice.domain.User;
import com.example.orchestrationservice.exception.UserAlreadyExistsException;
import com.example.orchestrationservice.service.OrchestrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/sbaapi/v1")
@CrossOrigin("*")
public class OrchestrationController {

    OrchestrationService orchestrationService;

    @Autowired
    public OrchestrationController(OrchestrationService orchestrationService) {
        this.orchestrationService = orchestrationService;
    }

    @PostMapping("/user")
    public ResponseEntity<?> registerAndSave(@RequestBody User user) throws UserAlreadyExistsException {

        ResponseEntity responseEntity = null;

        try {

            User userObj = this.orchestrationService.registerUser(user);
            responseEntity = new ResponseEntity(userObj, HttpStatus.CREATED);

        } catch(UserAlreadyExistsException e){
            throw  new UserAlreadyExistsException();
        }
    return  responseEntity;
    }
}
