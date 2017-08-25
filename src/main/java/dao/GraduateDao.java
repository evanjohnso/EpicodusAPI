package dao;

import dataModels.Graduate;

import java.util.List;

public interface GraduateDao {

    //Create
    void add(Graduate obj);

    //Read
    List<Graduate> getAll();
    Graduate findById(int id);
}
