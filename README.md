# <p align="center">Epicodus API</p>

#### <p align="center">By Evan Johnson</p>

## Description

A custom built public facing API providing information about student demographics for a local code school.
This project leverages H2 to quickly onboard a relational database. Postman was vital to injecting
new data into the server. If on a remote computer, a text.json file is included in the repo to facilitate testing.


## Setup/Installation Requirements

You will need Gradle installed on your device.

* ```git clone https://github.com/evanjohnso/EpicodusAPI.gi ```
* Install Postgres
* Open project in preferred IDE and launch app
* Go to localhost:4567 in your preferred browser or use Postman to add information

## Specifications

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
