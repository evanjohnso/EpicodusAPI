package dao;

import dataModels.Student;
import dataModels.Track;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;

public class DbTrackDao implements TrackDao {

    private final Sql2o path;

    public  DbTrackDao(Sql2o path) {
        this.path = path;
    }


    @Override
    public void add(Track newTrack) {
        String sql = "INSERT INTO tracks (focus, description, cost, duration, commitment)"
                        + "VALUES (:focus, :description, :cost, :duration, :commitment)";
        try (Connection con = path.open()) {
            int id = (int) con.createQuery(sql)
                                .bind(newTrack)
                                .executeUpdate()
                                .getKey();
            newTrack.setTrackId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void addTrackToCampuses(String location, int trackId) {
        String sql = "INSERT INTO campuses_tracks (location, trackId) VALUES (:location, :trackId)";
        try (Connection con = path.open()) {
            con.createQuery(sql)
                    .addParameter("location", location)
                    .addParameter("trackId", trackId)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public Track findById(int trackId) {
        try(Connection con = path.open()) {
            return con.createQuery("SELECT * FROM tracks WHERE trackId = :trackId")
                    .addParameter("trackId", trackId)
                    .executeAndFetchFirst(Track.class);
        }
    }

    @Override
    public List<Track> getAll() {
        try(Connection con = path.open()) {
            return con.createQuery("SELECT * FROM tracks")
                    .executeAndFetch(Track.class);
        }
    }

    @Override
    public List<Track> getAllTracksByLocation(String location) {
        List<Track> allTracksAtLocation = new ArrayList<>();
        String sql = "SELECT trackId FROM campuses_tracks WHERE location = :location";
        try (Connection con = path.open()) {
            List<Integer> trackIds = con.createQuery(sql)
                    .addParameter("location", location)
                    .executeAndFetch(Integer.class);
            for (Integer trackId: trackIds) {
                allTracksAtLocation.add(
                    con.createQuery("SELECT * FROM tracks WHERE trackId = :trackId")
                            .addParameter("trackId", trackId)
                            .executeAndFetchFirst(Track.class));
            }
            return allTracksAtLocation;
        }
    }

    @Override
    public void priceChange(int newPrice, int trackId) {
        String sql = "UPDATE tracks SET cost = :newPrice WHERE trackId = :trackId";
        try (Connection con = path.open()) {
            con.createQuery(sql)
                    .addParameter("newPrice", newPrice)
                    .addParameter("trackId", trackId)
                    .executeUpdate();
        }
    }


    @Override
    public void trackFinished(int trackId) {
        String sql = "DELETE FROM tracks WHERE trackId = :trackId";
        String joinDelete = "DELETE FROM campuses_tracks WHERE trackId = :trackId";
        try (Connection con = path.open()) {
            con.createQuery(sql)
                    .addParameter("trackId", trackId)
                    .executeUpdate();
            con.createQuery(joinDelete)
                    .addParameter("trackId", trackId)
                    .executeUpdate();
        }
    }
}
