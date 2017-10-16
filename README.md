# <p align="center">Epicodus API</p>

#### <p align="center">By Evan Johnson</p>

## Description

_A custom built public API providing information about Epicodus student's which has campuses in both Portland and Seattle_

## Setup/Installation Requirements

You will need Gradle installed on your device.

* ```console git clone https://github.com/evanjohnso/EpicodusAPI.gi ```
* Install Postgres
* Open project in preferred IDE and launch app
* Go to localhost:4567 in your preferred browser or use Postman to add information

## Specifications

* A text.json file is included to facilitate the feeding of new JSON for testing

***
# The API should return all students by a given track
* localhost:4567/Epicodus/:track/:trackId/students
![Alt text](https://user-images.githubusercontent.com/28036416/29736159-b2964d2a-89b3-11e7-8ef9-b567a416929c.png)
***

# The API should return the average age for all current and former Epicodus students
* localhost:4567/Epicodus/facts/age
![Alt text](https://user-images.githubusercontent.com/28036416/29736154-add475b4-89b3-11e7-9473-b99641115c92.png)
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