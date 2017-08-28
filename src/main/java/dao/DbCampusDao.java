package dao;

import dataModels.Campus;
import dataModels.Track;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class DbCampusDao implements CampusDao {
    private Sql2o path;
    
    public DbCampusDao(Sql2o path) {
        this.path = path;
    }
    
    @Override
    public void add(Campus school) {
        String sql = "INSERT INTO campuses (location) VALUES (:location)";
        try (Connection con = path.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(school)
                    .executeUpdate()
                    .getKey();
            school.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

//    @Override
//    public Campus findById(int id) {
//        try(Connection con = path.open()) {
//            return con.createQuery("SELECT * FROM campuses WHERE id = :id")
//                    .addParameter("id", id)
//                    .executeAndFetchFirst(Campus.class);
//        }
//    }

    public Campus find(int id) {
        try(Connection con = path.open()) {
            return con.createQuery("SELECT * FROM campuses WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Campus.class);
        }
    }
    public Campus find(String location) {
        try(Connection con = path.open()) {
            return con.createQuery("SELECT * FROM campuses WHERE location = :location")
                    .addParameter("location", location)
                    .executeAndFetchFirst(Campus.class);
        }
    }

    @Override
    public List<Campus> getAll() {
        try(Connection con = path.open()) {
            return con.createQuery("SELECT * FROM campuses")
                    .executeAndFetch(Campus.class);
        }
    }

    @Override
    public void schoolClosed(Campus school) {
        String sql = "DELETE FROM campuses WHERE id = :id";
        String joinDelete = "DELETE FROM campuses_tracks WHERE location = :location";
        try (Connection con = path.open()) {
            con.createQuery(sql)
                    .addParameter("id", school.getId())
                    .executeUpdate();
            con.createQuery(joinDelete)
                    .addParameter("location", school.getLocation())
                    .executeUpdate();
        }
    }
}
