package dao;


import dataModels.Graduate;
import dataModels.Student;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class DbStudentDao implements StudentDao {
    private final Sql2o path;

    public  DbStudentDao(Sql2o path) {
        this.path = path;
    }

    @Override
    public void add(Student newStudent) {
        String sql = "INSERT INTO students (gender, age, enrolled) VALUES"
                + "(:gender, :age, :enrolled)";
        try (Connection con = path.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(newStudent)
                    .executeUpdate()
                    .getKey();
            newStudent.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Student> getAll() {
        try(Connection con = path.open()) {
            return con.createQuery("SELECT * FROM students")
                    .executeAndFetch(Student.class);
        }
    }
    @Override
    public Student findById(int id) {
        try(Connection con = path.open()) {
            return con.createQuery("SELECT * FROM students WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Student.class);
        }
    }

    @Override
    public void dropped(int id) {
        try(Connection con = path.open()) {
            con.createQuery("UPDATE students SET enrolled = (false) WHERE id = :id")
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    @Override
    public void graduated(int id) {
        try(Connection con = path.open()) {
            con.createQuery("DELETE FROM students WHERE id = :id")
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

//    @Override
//    public int completion() {
//        try(Connection con = path.open()) {
//            Integer total = con.createQuery("SELECT * FROM students")
//                    .executeAndFetch(Student.class)
//                    .size();
//
//            Integer progress = con.createQuery("SELECT * FROM students WHERE enrolled = :status")
//                    .addParameter("status", true)
//                    .executeAndFetch(Student.class)
//                    .size();
//            float answer =   progress / total;
//            double what = 1 / 2;
//            return 1;
//        }
//    }

}
