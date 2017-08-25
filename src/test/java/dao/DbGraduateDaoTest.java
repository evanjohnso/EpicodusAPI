package dao;

import dataModels.*;
import dataModels.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class DbGraduateDaoTest {
    private Connection conn;
    private DbGraduateDao graduateDao;
    private DbStudentDao studentDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:epicodus;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        graduateDao = new DbGraduateDao(sql2o);
        studentDao = new DbStudentDao(sql2o);
        conn = sql2o.open();
    }
    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void add_addNewGraduateIdReturnsCorrectly() throws Exception {
        Graduate test = newGal();
        graduateDao.add(test);
        assertEquals(1, graduateDao.findById(test.getId()).getId());
    }

    @Test
    public void add_addNewStudentAndGetAllCorrectly() throws Exception {
        Graduate test = newGal();
        graduateDao.add(test); //add graduate before student is in DB so won't delete
        Student student = new Student("female", 28, false);
        studentDao.add(student);
        assertEquals(1, studentDao.getAll().size());
    }

    @Test
    public void add_addNewGraduateRemovesFromStudentDao() throws Exception {
        Student student = new Student("female", 28, false);
        Student student2 = new Student("male", 34, false);
        studentDao.add(student);
        studentDao.add(student2);
        //student graduates and gets pulled from students table --> to graduate table
        Graduate testGal = new Graduate(student.getId(), "female", 28, "Junior Dev", 45000, true );
        graduateDao.add(testGal);
        assertEquals(student2, studentDao.findById(student2.getId()));
    }


    //helpers
    public static Graduate newGal() {
        return new Graduate(1, "female", 28, "Junior Dev", 45000, true );
    }

    public static Graduate another() {
        return new Graduate(2, "female", 28, null, 0, false );
    }

}