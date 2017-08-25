import com.google.gson.Gson;
import dao.DbCampusDao;
import dao.DbStudentDao;
import dao.DbTrackDao;
import dataModels.*;
import org.sql2o.Sql2o;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        staticFileLocation("/public");

        String accessRoute = "jdbc:h2:~/epicodus_api.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o access = new Sql2o(accessRoute, "", "");
        DbTrackDao trackDao = new DbTrackDao(access);
        DbCampusDao campusDao = new DbCampusDao(access);
        DbStudentDao studentDao = new DbStudentDao(access);
        Gson gson = new Gson();

        //Create
        post("/Epicodus/new", "application/json", (request, response) -> {
            Campus newSchool = gson.fromJson(request.body(), Campus.class);
            campusDao.add(newSchool);
            return gson.toJson(newSchool);
        });

        //Read
        get("/Epicodus/all", "application/json", (request, response) -> {
            return gson.toJson(campusDao.getAll());
        });


        //Create
        post("/Epicodus/:campus/track/new", "application/json", (request, response) -> {
            Track newTrack= gson.fromJson(request.body(), Track.class);
            trackDao.add(newTrack);
            String campus = request.params("campus");
            trackDao.addTrackToCampuses(campus, newTrack.getTrackId());
            return gson.toJson(newTrack);
        });

        //Read
        get("/Epicodus/tracks/all", "application/json", (request, response) -> {
            return gson.toJson(trackDao.getAll());
        });

        get("/Epicodus/:campus/all", "application/json", (request, response) -> {
            String campus = request.params("campus");
            List<Track> campusFinder = trackDao.getAllTracksByLocation(campus);
            if (campusFinder.size() == 0){
                throw new ApiException(404, String.format("Sorry, looks like the %s campus doesn't have any tracks", request.params("campus")));
            }
            return gson.toJson(campusFinder);
        });

        post("/Epicodus/student/new", "application/json", (request, response) -> {
            Student newStudent= gson.fromJson(request.body(), Student.class);
            studentDao.add(newStudent);
            return gson.toJson(newStudent);
        });

        get("/Epicodus/facts/age", "application/json", (request, response) -> {
            return gson.toJson(studentDao.averageAge());
        });
        get("/Epicodus/facts/gender", "application/json", (request, response) -> {
            return gson.toJson(studentDao.genderDistribution());
        });
        get("/Epicodus/facts/completion", "application/json", (request, response) -> {
            return gson.toJson(studentDao.completion());
        });
        get("/Epicodus/:track/:trackId/students", "application/json", (request, response) -> {
            int trackId = Integer.parseInt(request.params("trackId"));
            return gson.toJson(studentDao.getAllStudentsByTrack(trackId));
        });

        exception(ApiException.class, (exc, req, res) -> {
            ApiException err = exc;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            res.type("application/json");
            res.status(err.getStatusCode());
            res.body(gson.toJson(jsonMap));
        });


        after((req, res) ->{
            res.type("application/json");
        });


    }
}
