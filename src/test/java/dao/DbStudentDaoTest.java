package dao;

import dataModels.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class DbStudentDaoTest {
    private Connection conn;
    private DbStudentDao studentDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:epicodus;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        studentDao = new DbStudentDao(sql2o);
        conn = sql2o.open();
    }
    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void add_addNewStudentIdReturnsCorrectly() throws Exception {
        Student test = newGal();
        studentDao.add(test);
        assertEquals(0, studentDao.findById(test.getId()).getId());
    }

    //helper
    public static Student newGal() {
        return new Student("female", 28, false);
    }
}