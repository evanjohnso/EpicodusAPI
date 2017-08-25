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

    public void add(Student newStudent) {
        String sql = "INSERT INTO students (gender, age, graduated) VALUES"
                + "(:gender, :age, :graduated)";
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

    public Student findById(int id) {
        try(Connection con = path.open()) {
            return con.createQuery("SELECT * FROM students WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Student.class);
        }
    }

}
