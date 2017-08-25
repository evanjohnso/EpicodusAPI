SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS students (
    id int PRIMARY KEY auto_increment,      --    (pk)

    gender VARCHAR,
    age int,
    graduated BOOLEAN
);

CREATE TABLE IF NOT EXISTS graduates (
  id int PRIMARY KEY auto_increment,
  studentId int,                            -- (foreign key)
  gender VARCHAR,
  age int,
  graduated BOOLEAN,
  jobTitle VARCHAR,
  salary int,
  employed BOOLEAN
);

CREATE TABLE IF NOT EXISTS tracks (
  id int PRIMARY KEY auto_increment,        --(pk)
  description VARCHAR,
  location VARCHAR,
  cost int,
  length VARCHAR,
  students int
);
