package dao;


import dataModels.Track;

import java.util.List;

public interface TrackDao {

    //Create
    void add(Track newTrack);
    void addTrackToCampuses(String location, int trackId);

    //Read
    List<Track> getAll();
    List<Track> getAllTracksByLocation(String location);
    Track findById(int trackId);

    //Update
    void priceChange(int newPrice, int trackId);

    //Delete
    void trackFinished(int trackId);
}
