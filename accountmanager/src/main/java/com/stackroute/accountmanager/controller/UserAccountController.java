package com.stackroute.accountmanager.controller;

import com.stackroute.accountmanager.exception.UserNotFoundException;
import com.stackroute.accountmanager.model.UserAccount;
import com.stackroute.accountmanager.service.SecurityTokenGenerator;
import com.stackroute.accountmanager.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/sbaapi/v1/accountmanagerservice")
public class UserAccountController {

    private ResponseEntity responseEntity;
    private UserAccountService userService;
    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserAccountController(UserAccountService userService, SecurityTokenGenerator securityTokenGenerator) {
        this.userService = userService;
        this.securityTokenGenerator = securityTokenGenerator;
    }

    @PostMapping("/save")
    public ResponseEntity saveUser(@RequestBody UserAccount user){

        userService.saveUser(user);
        return responseEntity = new ResponseEntity(user, HttpStatus.CREATED);

    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody UserAccount user) throws UserNotFoundException {

        Map<String, String > map = null;
        try {

            UserAccount userObj=userService.findByUserNameAndPassword(user.getUserName(),user.getPassword());
            if(userObj.getUserName().equals(user.getUserName())){
                map=securityTokenGenerator.generateToken(user);
            }
            responseEntity = new ResponseEntity(map, HttpStatus.OK);
        }catch (UserNotFoundException e){
            throw new UserNotFoundException();
        }catch (Exception e) {
            responseEntity = new ResponseEntity("Try after sometimes!!!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;

    }
}
