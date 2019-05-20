package com.stackroute.muzixmanager.service;

import com.stackroute.muzixmanager.exception.TrackAlreadyExistsException;
import com.stackroute.muzixmanager.exception.TrackNotFoundException;
import com.stackroute.muzixmanager.model.Artist;
import com.stackroute.muzixmanager.model.Image;
import com.stackroute.muzixmanager.model.Track;
import com.stackroute.muzixmanager.model.User;
import com.stackroute.muzixmanager.repository.MuzixRepository;
import com.stackroute.muzixmanager.repository.MuzixRepositoryTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class MuzixServiceTest {

    @Mock
    private MuzixRepository muzixRepository;
    @InjectMocks
    private MuzixServiceImpl muzixService;


    private Image image;
    private Artist artist;
    private Track track;
    private User user;
    private List<Track> listTrack;


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        image = new Image( 1, "http:url" , "large");
        artist = new Artist( 101, "Jonhn", "new url" ,image);
        track = new Track( "Track1", "MyNewTracks","new track url", "123" , "new comment",artist);
        listTrack = new ArrayList<>();
        listTrack.add(track);
        user = new User("John123","john@gmail.com", listTrack);

    }

    @After
    public void tearDown(){
        muzixRepository.deleteAll();
        listTrack= null;
        image = null;
        artist = null;
        track = null;
        user = null;
    }

    @Test
    public void testSaveUserTrackSuccess () throws TrackAlreadyExistsException {
        user = new User("John456","john@gmail.com", null);
        when(muzixRepository.findByUserName(user.getUserName())).thenReturn(user);
        User fetchUser = muzixService.saveUserTrackToPlayList(track,user.getUserName());
        Assert.assertEquals(user,fetchUser);
        verify(muzixRepository,timeout(1)).findByUserName(user.getUserName());
        verify(muzixRepository,times(1)).save(user);
    }

    @Test
    public void testDeleteUserTrackFromWishList () throws TrackNotFoundException {

        when(muzixRepository.findByUserName(user.getUserName())).thenReturn(user);
        User fetchUser = muzixService.deleteUserTrackFromPlayList(user.getUserName(),track.getTrackId());
        Assert.assertEquals(user,fetchUser);
        verify(muzixRepository,times(1)).findByUserName(user.getUserName());
        verify(muzixRepository,times(1)).save(user);
    }

    @Test
    public void testUpdateCommentForTrack () throws TrackNotFoundException {

        when(muzixRepository.findByUserName(user.getUserName())).thenReturn(user);
        User fetchUser = muzixService.updateCommentForTrack("new comments updated", track.getTrackId(),user.getUserName());
        Assert.assertEquals(fetchUser.getTrackList().get(0).getComments(),"new comments updated");
        verify(muzixRepository,times(1)).findByUserName(user.getUserName());
        verify(muzixRepository,times(1)).save(user);
    }

    @Test
    public void testGetAllUserTrackFromWishList () throws Exception {

        when(muzixRepository.findByUserName(user.getUserName())).thenReturn(user);
        List<Track>  list = muzixService.getAllUserTrackFromPlayList(user.getUserName());
        Assert.assertEquals(listTrack,list);
        verify(muzixRepository,times(1)).findByUserName(user.getUserName());
    }

}
