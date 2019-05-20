package com.stackroute.muzixmanager.repository;

import com.stackroute.muzixmanager.model.Artist;
import com.stackroute.muzixmanager.model.Image;
import com.stackroute.muzixmanager.model.Track;
import com.stackroute.muzixmanager.model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataMongoTest
public class MuzixRepositoryTest {

    @Autowired
    private MuzixRepository muzixRepository;

    private User user;
    private Track track;

    @Before
    public void setUp(){
        Image image = new Image(  1, "http:url" , "large");
        Artist artist = new Artist( 101, "Jonhn",  "new url" ,image);
        track = new Track( "Track1", "MyNewTracks","new track url", "123" , "new commets",artist);
        List<Track> trackList = new ArrayList<>();
        trackList.add(track);
        user = new User("John123","john@gmail.com", trackList);
    }

    @After
    public void tearDown(){

        muzixRepository.deleteAll();
    }

    @Test
    public void testSaveUserTrack() {
        muzixRepository.save(user);
        User fetchedUserObj = muzixRepository.findByUserName(user.getUserName());
        List<Track> listTrack = fetchedUserObj.getTrackList();
        Assert.assertEquals(listTrack.get(0).getTrackId(),user.getTrackList().get(0).getTrackId());
    }
}
