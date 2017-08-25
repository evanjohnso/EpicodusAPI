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
    List<Student> getAllStudentsByTrack(int trackId);
    Student findById(int id);
    double completion();
    int averageAge();
    String genderDistribution();

    //Update
    void dropped(int id);

    //Delete
    void graduated(int id);


}
