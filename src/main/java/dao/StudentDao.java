package dao;

import dataModels.Student;

import java.util.List;

/**
 * Created by Guest on 8/25/17.
 */
public interface StudentDao {

    //Create
    void add(Student obj);

    //Read
    List<Student> getAll();
    Student findById(int id);


}
