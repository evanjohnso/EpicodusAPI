# Epicodus API

#### By Evan Johnson

## Description

_A public API providing information about Epicodus code school which has campuses in both Portland and Seattle_


## Setup/Installation Requirements

You will need Gradle installed on your device.

* Clone the repo from git hub.
* Install Postgres
* Open project in preferred IDE and launch app
* Go to localhost:4567 in your preferred browser or use Postman to add information

## Specifications

# A text.json file is included to facilitate the feeding of new JSON for testing

The API should take new tracks
![Alt text](src/resources/public/images/newTrack.png)

The API should return all tracks by location
![Alt text](images/allTrackByLocation.png)

The API should return all students by a given track
![Alt text](/allStudentsByTrack.png)

The API should return the average age for all current and former Epicodus students
![Alt text](/AverageAge.png)

The API should return the gender distribution for all current and former Epicodus students
![Alt text](/GenderDistribution.png)

The API should return the completion percentage for all tracks
![Alt text](/CompletionPercentage.png)

The API should create custom errors when information is unavailable
![Alt text](/CustomErrorHandling.png)

## To Be Released
 * Change status of student to graduated
 * All information about students is available for graduates in addition to salary and job title
 * Gender/Age/Completion distributions for specific tracks at Epicodus


## Technologies Used

* _IntelliJ_
* _Java_
* _PostgreSQL_
* _SQL2o_
* _H2_
* _Spark_
* _Postman_


### License

MIT Copyright &copy; 2017 Evan Johnson