package dao;

import dataModels.Campus;
import dataModels.Track;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Arrays;

import static org.junit.Assert.*;


public class DbCampusDaoTest {
    private Connection conn;
    private DbCampusDao campusDao;
    private DbTrackDao trackDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:epicodus;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        campusDao = new DbCampusDao(sql2o);
        trackDao = new DbTrackDao(sql2o);
        conn = sql2o.open();
    }
    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void add() throws Exception {
        Campus seattle = new Campus("Seattle");
        campusDao.add(seattle);
        assertEquals(seattle, campusDao.findById(seattle.getId()));
    }

    @Test
    public void findById() throws Exception {
        Campus seattle = new Campus("Seattle");
        campusDao.add(seattle);
        campusDao.add(new Campus("Portland"));
        assertEquals(seattle, campusDao.findById(seattle.getId()));
    }

    @Test
    public void schoolClosed() throws Exception {
        Campus seattle = new Campus("Seattle");
        campusDao.add(seattle);
        campusDao.add(new Campus("Portland"));
        campusDao.schoolClosed(seattle);
        assertEquals(null, campusDao.findById(seattle.getId()));
    }

    @Test
    public void closeSchoolMakesAllTracksAtThatSchoolDisappear() throws Exception {
        Campus seattle = new Campus("Seattle");
        campusDao.add(seattle);
        Track ruby = new Track("Ruby", "Is not the best", 6900, "27 weeks", "45hrs/week");
        Track java = new Track("Java", "Is the Best", 6900, "27 weeks", "45hrs/week");
        trackDao.add(ruby);
        trackDao.addTrackToCampuses("Seattle", ruby.getTrackId());
        trackDao.add(java);
        trackDao.addTrackToCampuses("Portland", java.getTrackId());

        campusDao.add(new Campus("Portland"));

        campusDao.schoolClosed(seattle);
        assertEquals(Arrays.asList(java), trackDao.getAllTracksByLocation("Portland"));
    }

}