SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS students (
    id int PRIMARY KEY auto_increment,
    trackId int,
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
  trackId int PRIMARY KEY auto_increment,
  focus VARCHAR,
  description VARCHAR,
  cost int,
  duration VARCHAR,
  commitment VARCHAR
);

CREATE TABLE IF NOT EXISTS campuses_tracks (
  id int PRIMARY KEY auto_increment,
  location VARCHAR, --foreign KEY
  trackId int   --foreign KEY
);
