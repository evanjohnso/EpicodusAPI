package dao;

import dataModels.Track;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DbTrackDaoTest {
    private Connection conn;
    private DbTrackDao trackDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:epicodus;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        trackDao = new DbTrackDao(sql2o);
        conn = sql2o.open();
    }
    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void add() throws Exception {
        Track one = fresh();
        trackDao.add(one);
        assertEquals(one, trackDao.findById(one.getTrackId()));
    }

    @Test
    public void addTrackToCampuses() throws Exception {
        Track seattle = fresh();
        trackDao.add(seattle);
        Track ruby = ruby();
        trackDao.add(ruby);
        trackDao.addTrackToCampuses("Seattle", seattle.getTrackId());
        trackDao.addTrackToCampuses("Portland", ruby.getTrackId());
        assertEquals(Arrays.asList(ruby), trackDao.getAllTracksByLocation("Portland"));
    }


    @Test
    public void priceChange() throws Exception {
        trackDao.add(fresh());
        trackDao.add(fresh());
        Track ruby = ruby();
        trackDao.add(ruby);
        trackDao.priceChange(8400, ruby.getTrackId());
        assertEquals(8400, trackDao.findById(ruby.getTrackId()).getCost());
    }

    @Test
    public void trackFinished() throws Exception {
        trackDao.add(fresh());
        trackDao.add(fresh());
        Track ruby = ruby();
        trackDao.add(ruby);
        trackDao.trackFinished(ruby.getTrackId());
        assertEquals(2, trackDao.getAll().size() );
    }

    //helper
    public Track fresh() {
        return new Track("Java", "Is the Best", 6900, "27 weeks", "45hrs/week");
    }

    public Track ruby() {
        return new Track("Ruby", "Is the Best", 6900, "27 weeks", "45hrs/week");
    }

}