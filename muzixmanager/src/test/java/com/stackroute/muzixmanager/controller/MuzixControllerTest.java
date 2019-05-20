package com.stackroute.muzixmanager.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.muzixmanager.exception.TrackAlreadyExistsException;
import com.stackroute.muzixmanager.model.Artist;
import com.stackroute.muzixmanager.model.Image;
import com.stackroute.muzixmanager.model.Track;
import com.stackroute.muzixmanager.model.User;
import com.stackroute.muzixmanager.service.MuzixService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MuzixController.class)
public class MuzixControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MuzixService muzixService;

    private Image image;
    private Artist artist;
    private Track track;
    private User user;
    private List<Track> trackList;

    @Before
    public void setUp() throws Exception {
        trackList = new ArrayList<>();
        image = new Image(1,"http:url","large");
        artist = new Artist(101,"Jonhn","new url",image);
        track = new Track("Track1","TrackName","new track url","123","new comments",artist);
        trackList.add(track);
        image = new Image(2,"http:url","large");
        artist = new Artist(102,"Jonhn","new url",image);
        track = new Track("Track2","TrackName123","new track url","123","new comments updated",artist);
        trackList.add(track);
        user = new User("john123","john@gmail.com", trackList);
    }

    @After
    public void tearDown() throws Exception {
        image = null;
        artist = null;
        track = null;
        user = null;
    }

    @Test
    public void testSaveTrackSuccess() throws Exception {
        when(muzixService.saveUserTrackToPlayList(any(),eq(user.getUserName()))).thenThrow(TrackAlreadyExistsException.class);
        mockMvc.perform(post("/api/usertrackservice/user/{userName}/track" , user.getUserName())
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonToString(track))).andExpect(status().isConflict()).andDo(print());

        verify(muzixService,times( 1)).saveUserTrackToPlayList(any(),eq(user.getUserName()));

    }

    @Test
    public void testSaveTrackFailure() throws Exception {
        when(muzixService.saveUserTrackToPlayList(any(),eq(user.getUserName()))).thenReturn(user);
        mockMvc.perform(post("/api/usertrackservice/user/{userName}/track" , user.getUserName())
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonToString(track))).andExpect(status().isCreated()).andDo(print());

        verify(muzixService,times( 1)).saveUserTrackToPlayList(any(),eq(user.getUserName()));

    }

    @Test
    public void testUpdateCommentSuccess() throws Exception {
        when(muzixService.updateCommentForTrack(track.getComments(),track.getTrackId(),user.getUserName())).thenReturn(user);
        mockMvc.perform(patch("/api/usertrackservice/user/{userName}/track" , user.getUserName())
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonToString(track))).andExpect(status().isOk()).andDo(print());

        verify(muzixService,times( 1)).updateCommentForTrack(track.getComments(),track.getTrackId(),user.getUserName());

    }


    @Test
    public void testDeleteUserTrack() throws Exception {
        when(muzixService.deleteUserTrackFromPlayList(user.getUserName(),track.getTrackId())).thenReturn(user);
        mockMvc.perform(delete("/api/usertrackservice/user/{userName}/{trackID}" , user.getUserName(),track.getTrackId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonToString(track))).andExpect(status().isOk()).andDo(print());

        verify(muzixService,times( 1)).deleteUserTrackFromPlayList(user.getUserName(),track.getTrackId());

    }

    @Test
    public void testGetAllTracksFromWishList() throws Exception {
        when(muzixService.getAllUserTrackFromPlayList(user.getUserName())).thenReturn(trackList);
        mockMvc.perform(get("/api/usertrackservice/user/{userName}/track" , user.getUserName())
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonToString(track))).andExpect(status().isOk()).andDo(print());

        verify(muzixService,times( 1)).getAllUserTrackFromPlayList(user.getUserName());

    }



    private static  String jsonToString(final Object obj) throws JsonProcessingException {
        String result;
        try{
            ObjectMapper objectMapper = new ObjectMapper() ;
            String jsonContent = objectMapper.writeValueAsString(obj);
            result = jsonContent;
        }catch(JsonProcessingException e){
            result = "JSON Processing error";
        }
        return result;
    }


}
