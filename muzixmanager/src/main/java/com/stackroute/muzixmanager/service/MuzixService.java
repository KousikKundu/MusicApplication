package com.stackroute.muzixmanager.service;

import com.stackroute.muzixmanager.exception.TrackAlreadyExistsException;
import com.stackroute.muzixmanager.exception.TrackNotFoundException;
import com.stackroute.muzixmanager.exception.UserAlreadyExistsException;
import com.stackroute.muzixmanager.model.Track;
import com.stackroute.muzixmanager.model.User;

import java.util.List;

public interface MuzixService {

    User saveUserTrackToPlayList(Track track, String userName) throws TrackAlreadyExistsException;
    User deleteUserTrackFromPlayList(String userName, String id)  throws TrackNotFoundException;
    User updateCommentForTrack(String comment , String trackId, String userName) throws TrackNotFoundException ;
    List<Track> getAllUserTrackFromPlayList(String userName) throws Exception ;

    User registerUser(User user) throws UserAlreadyExistsException;
}
