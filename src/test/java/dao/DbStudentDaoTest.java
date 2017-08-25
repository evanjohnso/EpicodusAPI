package dao;

import dataModels.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.lang.reflect.Array;
import java.util.Arrays;

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
        assertEquals(1, studentDao.findById(test.getId()).getId());
    }

    @Test
    public void getAll_addMultipleAndReturn() throws Exception {
        Student test = newGal();
        Student second = another();
        studentDao.add(test);
        studentDao.add(second);
        Student[] array = {test, second};
        assertEquals(Arrays.asList(array), studentDao.getAll());
    }

    @Test
    public void findById_findByIdReturnsCorrectly() throws Exception {
        Student test = newGal();
        Student second = another();
        studentDao.add(test);
        studentDao.add(second);
        assertEquals(second, studentDao.findById(second.getId()));
    }
    @Test
    public void dropped() throws  Exception {
        Student test = newGal();
        Student second = another();
        studentDao.add(test);
        studentDao.add(second);
        studentDao.dropped(second.getId());
        assertEquals(false, studentDao.findById(second.getId()).isEnrolled());
    }

    @Test
    public void graduated() throws  Exception {
        Student test = newGal();
        Student second = another();
        studentDao.add(test);
        studentDao.add(second);
        studentDao.graduated(second.getId());
        assertEquals(Arrays.asList(test), studentDao.getAll() );
    }

    @Test
    public void averageAge() throws Exception {
        Student test = newGal();
        Student second = another();
        studentDao.add(test);
        studentDao.add(second);
        studentDao.add(new Student("male", 31, false));
        assertEquals(28, studentDao.averageAge());
    }

    @Test
    public void genderDistribution() throws Exception {
        Student test = newGal();
        Student second = another();
        studentDao.add(test);
        studentDao.add(second);
        studentDao.add(new Student("other", 31, false));
        studentDao.add(new Student("other", 31, false));
        studentDao.add(new Student("male", 31, false));
        assertEquals("Current student distribution at Epicodus is 1 female, 2 male, 2 other",studentDao.genderDistribution());
    }


//    @Test
//    public void completion_returnsCorrectly() throws Exception {
//        Student test = newGal();
//        Student second = another();
//        studentDao.add(new Student());
//        studentDao.add(new Student());
//        studentDao.add(test);
//        studentDao.add(second);
//        studentDao.add(new Student("male", 18, false));
////        assertEquals(4, studentDao.completion());
//    }

    //helpers
    public static Student newGal() {
        return new Student("female", 28, true);
    }

    public static Student another() {
        return new Student("male", 26, true);
    }
}