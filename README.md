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

* A text.json file is included to facilitate the feeding of new JSON for testing

***
# The API should take new tracks:
* localhost:4567/Epicodus/:campus/track/new
![Alt text](https://user-images.githubusercontent.com/28036416/29736152-a8c4e8e2-89b3-11e7-846a-b4bd1cd7e653.png)
***

# The API should return all tracks by location
* localhost:4567/Epicodus/tracks/all
![Alt text](https://user-images.githubusercontent.com/28036416/29736156-b05227be-89b3-11e7-9c95-5f7cc422755c.png)
***

# The API should return all students by a given track
* localhost:4567/Epicodus/:track/:trackId/students
![Alt text](https://user-images.githubusercontent.com/28036416/29736159-b2964d2a-89b3-11e7-8ef9-b567a416929c.png)
***

# The API should return the average age for all current and former Epicodus students
* localhost:4567/Epicodus/facts/age
![Alt text](https://user-images.githubusercontent.com/28036416/29736154-add475b4-89b3-11e7-9473-b99641115c92.png)
***

# The API should return the gender distribution for all current and former Epicodus students
* localhost:4567/Epicodus/facts/gender
![Alt text](https://user-images.githubusercontent.com/28036416/29736166-bb0c56fc-89b3-11e7-98da-5e94484e126f.png)
***

# The API should return the completion percentage for all tracks
* localhost:4567/Epicodus/facts/completion
![Alt text](https://user-images.githubusercontent.com/28036416/29736158-b15feb5a-89b3-11e7-9177-20272f6f61c6.png)
***

# The API should create custom errors when information is unavailable
![Alt text](https://user-images.githubusercontent.com/28036416/29736161-b3cbd4f8-89b3-11e7-9840-c21a83d3bdf8.png)

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