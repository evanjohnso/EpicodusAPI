package dao;

import dataModels.Campus;

import java.util.List;

public interface CampusDao {

    //Create
    void add(Campus school);

    //Read
//    Campus findById(int id);
    List<Campus> getAll();
    Campus find(int id);
    Campus find(String location);

    //Delete
    void schoolClosed(Campus school);


}
