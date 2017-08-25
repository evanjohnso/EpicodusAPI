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
    public int averageAge() {
        try(Connection con = path.open()) {
            int average = 0;
            List<Integer> ages = con.createQuery("SELECT age FROM students")
                    .executeAndFetch(Integer.class);
            for (Integer age: ages) {
                average += age;
            }
            return average / ages.size();

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

    @Override
    public String genderDistribution() {
        try(Connection con = path.open()) {
            List<String> genders = con.createQuery("SELECT gender FROM students")
                    .executeAndFetch(String.class);
            int female, male, other;
            female = male = other = 0;
            for (String gender: genders) {
                switch (gender) {
                    case "female":
                        female ++;
                        break;
                    case "male":
                        male ++;
                        break;
                    case "other":
                        other ++;
                        break;
                }
            }
            return String.format("Current student distribution at Epicodus is %d female, %d male, %d other", female, male, other);

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
//            return (progress /total) * 100;
//        }
//    }

}
