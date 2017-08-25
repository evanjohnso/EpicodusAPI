package dao;

import dataModels.Campus;

import java.util.List;

public interface CampusDao {

    //Create
    void add(Campus school);

    //Read
    Campus findById(int id);

    //Delete
    void schoolClosed(Campus school);


}
