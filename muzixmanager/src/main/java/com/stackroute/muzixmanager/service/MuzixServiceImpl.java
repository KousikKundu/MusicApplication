package com.stackroute.muzixmanager.service;

import com.stackroute.muzixmanager.exception.TrackAlreadyExistsException;
import com.stackroute.muzixmanager.exception.TrackNotFoundException;
import com.stackroute.muzixmanager.exception.UserAlreadyExistsException;
import com.stackroute.muzixmanager.model.Track;
import com.stackroute.muzixmanager.model.User;
import com.stackroute.muzixmanager.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MuzixServiceImpl implements MuzixService {

    private MuzixRepository muzixRepository;

    @Autowired
    public MuzixServiceImpl(MuzixRepository muzixRepository) {
        this.muzixRepository = muzixRepository;
    }

    @Override
    public User saveUserTrackToPlayList(Track track, String userName) throws TrackAlreadyExistsException {
        User fetchedUserObj = muzixRepository.findByUserName(userName);

        List<Track> fetchedTracks = fetchedUserObj.getTrackList();

        if(fetchedTracks != null) {

            for(Track trackObj : fetchedTracks){

                if(trackObj.getTrackId().equals(track.getTrackId())){
                    throw new TrackAlreadyExistsException();
                }
            }

            fetchedTracks.add(track);
            fetchedUserObj.setTrackList(fetchedTracks);
            /*UserDTO userDTO = new UserDTO();
            userDTO.setUserName(userName);
            userDTO.setEmail(fetchedUserObj.getEmail());
            List list = new ArrayList();
            list.add(fetchedTracks);
            userDTO.setTrackList(list);*/
            muzixRepository.save(fetchedUserObj);
           // producer.sendToRabbitMqTrackObj(userDTO);
        }else {

            fetchedTracks = new ArrayList<Track>();
            fetchedTracks.add(track);
            fetchedUserObj.setTrackList(fetchedTracks);

            /*UserDTO userDTO = new UserDTO();
            userDTO.setUserName(userName);
            userDTO.setEmail(fetchedUserObj.getEmail());
            List list = new ArrayList();
            list.add(fetchedTracks);
            userDTO.setTrackList(list);*/

            muzixRepository.save(fetchedUserObj);
            //producer.sendToRabbitMqTrackObj(userDTO);
        }
        return fetchedUserObj;
    }

    @Override
    public User deleteUserTrackFromPlayList(String userName, String id) throws TrackNotFoundException {
        User fetchedUserObj = muzixRepository.findByUserName(userName);
        List<Track> fetchedTracks = fetchedUserObj.getTrackList();

        if(fetchedTracks.size() >0) {

            for(int i=0; i<fetchedTracks.size();i++){
                if(id.equals(fetchedTracks.get(i).getTrackId())){
                    fetchedTracks.remove(i);
                    fetchedUserObj.setTrackList(fetchedTracks);
                    muzixRepository.save(fetchedUserObj);
                }
            }

        }else {

            throw new TrackNotFoundException();
        }
        return fetchedUserObj;
    }

    @Override
    public User updateCommentForTrack(String comment, String trackId, String userName) throws TrackNotFoundException {
        User fetchedUserObj = muzixRepository.findByUserName(userName);
        List<Track> fetchedTracks = fetchedUserObj.getTrackList();

        if(fetchedTracks.size() >0) {

            for(int i=0; i<fetchedTracks.size();i++){
                if(trackId.equals(fetchedTracks.get(i).getTrackId())){
                    fetchedTracks.get(i).setComments(comment);
                    fetchedUserObj.setTrackList(fetchedTracks);
                    muzixRepository.save(fetchedUserObj);
                }
            }

        }else {

            throw new TrackNotFoundException();
        }
        return fetchedUserObj;
    }

    @Override
    public List<Track> getAllUserTrackFromPlayList(String userName) throws Exception {
        User fetchedUserObj = muzixRepository.findByUserName(userName);

        return fetchedUserObj.getTrackList();
    }

    @Override
    public User registerUser(User user) throws UserAlreadyExistsException {
        /*UserDTO userDTO = new UserDTO();
        userDTO.setUserName(user.getUserName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());*/

        User fetchedUserObj = muzixRepository.findByUserName(user.getUserName());
        if(fetchedUserObj != null ) {
            throw new UserAlreadyExistsException();
        }
        else{
            muzixRepository.save(user) ;
          //  producer.sendMessageToRabbitMq(userDTO);
        }
        return user;
    }

}
