package dao;

import org.sql2o.*;
import dataModels.*;

import java.util.List;

public class DbGraduateDao {
    private final Sql2o path;

    //Constructor
    public DbGraduateDao(Sql2o path) {
        this.path = path;
    }

    public void add(Graduate newGrad) {
        String sql = "INSERT INTO graduates (studentId, gender, age, graduated, jobTitle, salary, employed) VALUES"
                        + "(:studentId, :gender, :age, :graduated, :jobTitle, :salary, :employed)";
        String delete = "DELETE FROM students WHERE id = :studentId";
        try (Connection con = path.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(newGrad)
                    .executeUpdate()
                    .getKey();
            newGrad.setId(id);
            //student graduates and gets pulled from students table --> to graduate table (no double counting)
            con.createQuery(delete)
                    .addParameter("studentId", newGrad.getStudentId())
                    .executeUpdate();

        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    public List<Graduate> getAll() {
        try(Connection con = path.open()) {
            return con.createQuery("SELECT * FROM graduates")
                    .executeAndFetch(Graduate.class);
        }
    }

    public Graduate findById(int id) {
        try(Connection con = path.open()) {
            return con.createQuery("SELECT * FROM graduates WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Graduate.class);
        }
    }
}

