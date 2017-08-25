SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS students (
    id int PRIMARY KEY auto_increment,
    gender VARCHAR,
    age int,
    enrolled BOOLEAN
);

CREATE TABLE IF NOT EXISTS graduates (
  id int PRIMARY KEY auto_increment,
  studentId int,    --foreign KEY
  gender VARCHAR,
  age int,
  employed BOOLEAN,
  jobTitle VARCHAR,
  salary int,
);

CREATE TABLE IF NOT EXISTS campuses (
  id int PRIMARY KEY auto_increment,
  location VARCHAR
);

CREATE TABLE IF NOT EXISTS tracks (
  id int PRIMARY KEY auto_increment,
  focus VARCHAR,
  description VARCHAR,
  location VARCHAR,
  cost int,
  length VARCHAR,
  students int,
  commitment VARCHAR
);

CREATE TABLE IF NOT EXISTS campuses_tracks (
  id int PRIMARY KEY auto_increment,
  campusId int, --foreign KEY
  trackId int   --foreign KEY
);
