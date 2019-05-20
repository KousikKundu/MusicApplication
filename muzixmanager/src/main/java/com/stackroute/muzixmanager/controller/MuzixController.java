package com.stackroute.muzixmanager.controller;

import com.stackroute.muzixmanager.exception.TrackAlreadyExistsException;
import com.stackroute.muzixmanager.exception.TrackNotFoundException;
import com.stackroute.muzixmanager.exception.UserAlreadyExistsException;
import com.stackroute.muzixmanager.model.Track;
import com.stackroute.muzixmanager.model.User;
import com.stackroute.muzixmanager.service.MuzixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/sbaapi/v1/muzixmanagerservice")
public class MuzixController {

    private MuzixService muzixService;
    private ResponseEntity responseEntity;

    @Autowired
    public MuzixController(MuzixService muzixService) {
        this.muzixService = muzixService;
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody User user) throws UserAlreadyExistsException {

        try {
            muzixService.registerUser(user);
            responseEntity = new ResponseEntity<User>(user, HttpStatus.CREATED);
        } catch (UserAlreadyExistsException e){
            throw new UserAlreadyExistsException();
        }
        return responseEntity;
    }

    @PostMapping("/user/{userName}/track")
    public ResponseEntity<?>  saveUserTrackToPlayList(@RequestBody Track track , @PathVariable("userName") String userName) throws TrackAlreadyExistsException {

        try {
            System.out.println(" inside controller " + userName);
            User user = muzixService.saveUserTrackToPlayList(track,userName);
            System.out.println(" service method is called " );
            responseEntity = new ResponseEntity<User>(user, HttpStatus.CREATED);
        } catch (TrackAlreadyExistsException e){
            throw new TrackAlreadyExistsException();
        }catch (Exception e) {
            System.out.println(" inside controller " + e.getMessage());
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(e.getMessage() ,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

    @DeleteMapping("/user/{userName}/{trackID}")
    public ResponseEntity<?>  deleteUserTrackToWishList(@PathVariable("userName") String userName,@PathVariable("trackID") String trackId) throws TrackNotFoundException {

        try {
            User user = muzixService.deleteUserTrackFromPlayList(userName,trackId);
            responseEntity = new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (TrackNotFoundException e){
            throw new TrackNotFoundException();
        }catch (Exception e) {
            responseEntity = new ResponseEntity<>(e.getMessage() ,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }


    @PatchMapping("/user/{userName}/track")
    public ResponseEntity<?>  updateCommentForUSerTrack(@RequestBody Track track, @PathVariable("userName") String userName) throws TrackNotFoundException {

        try {
            User user = muzixService.updateCommentForTrack(track.getComments(),track.getTrackId(),userName);
            responseEntity = new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (TrackNotFoundException e){
            throw new TrackNotFoundException();
        }catch (Exception e) {
            responseEntity = new ResponseEntity<>(e.getMessage() ,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

    @GetMapping("/user/{userName}/track")
    public ResponseEntity<?> getAllUserTrackFromWishList(@PathVariable("userName") String userName) {

        try{
            responseEntity= new ResponseEntity(muzixService.getAllUserTrackFromPlayList(userName), HttpStatus.OK);
        }catch (Exception e) {
            responseEntity = new ResponseEntity<>(e.getMessage() ,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}
