package com.stackroute.muzixrecommendersystem.service;

import com.stackroute.muzixrecommendersystem.model.Track;

import java.util.List;

public interface MuzixRecommendedService {

    List<Track> getAllUserTrackFromPlayList(String userName) throws Exception ;
}
