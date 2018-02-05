create database university;

use university;

CREATE TABLE IF NOT EXISTS scholarship (
  id_scholarship INT NOT NULL auto_increment primary key ,
  scholarship_price DOUBLE NOT NULL)
ENGINE = InnoDB;

-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS faculty (
  id_faculty INT NOT NULL auto_increment primary key,
  faculty_name VARCHAR(45) NOT NULL,
  UNIQUE INDEX faculty_name_UNIQUE (faculty_name ASC))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS chair (
  id_chair INT NOT NULL auto_increment primary key,
  chair_name VARCHAR(45) NOT NULL,
  id_faculty INT NOT NULL,
  UNIQUE INDEX chair_name_UNIQUE (chair_name ASC))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS specialty (
  id_specialty INT NOT NULL auto_increment primary key,
  id_chair INT NOT NULL,
  specialty_name VARCHAR(45) NOT NULL,
  specialty_number VARCHAR(20) NOT NULL,
  UNIQUE INDEX specialty_number_UNIQUE (specialty_number ASC))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS groups (
  id_group INT NOT NULL auto_increment primary key,
  group_name VARCHAR(30) NOT NULL,
  group_number INT NOT NULL,
  number_of_students INT NOT NULL,
  id_speciality INT NOT NULL)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS student (
  id_student INT NOT NULL auto_increment primary key,
  first_name VARCHAR(45) NOT NULL,
  middle_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NOT NULL,
  photo BLOB NULL,
  autobiography TEXT NULL,
  birthday_date DATE NOT NULL,
  admission_date DATE NOT NULL,
  student_gradebook INT NOT NULL,
  overral_rating DOUBLE NULL,
  email_address VARCHAR(45) NULL,
  phone_number BIGINT NULL,
  list_of_disciplines_studied TEXT NULL,
  id_town INT NOT NULL,
  id_scholarship INT NOT NULL,
  id_group INT NOT NULL,
  UNIQUE INDEX student_gradebook_UNIQUE (student_gradebook ASC))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS semester (
  id_semester INT NOT NULL auto_increment primary key,
  semester_number INT NOT NULL,
  UNIQUE INDEX semester_number_UNIQUE (semester_number ASC))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS subject (
  id_subject INT NOT NULL auto_increment primary key,
  subject_name VARCHAR(45) NOT NULL,
  id_semester INT NOT NULL)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS lecturer (
  id_lecturer INT NOT NULL auto_increment primary key,
  first_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NOT NULL,
  email_address VARCHAR(45) NULL,
  phone_number BIGINT NULL)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS lecturer_has_subject (
  id_lecturer INT NOT NULL ,
  id_subject INT NOT NULL,
  constraint pk_lecturer_has_subject_lecturer_subject 
	primary key (id_lecturer,id_subject))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS control_type (
  id_control_type INT NOT NULL auto_increment primary key,
  control_type_name VARCHAR(15) NOT NULL,
  UNIQUE INDEX control_type_name_UNIQUE (control_type_name ASC))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS session (
  id_session INT NOT NULL auto_increment primary key,
  exam_date DATE NOT NULL,
  id_student INT NOT NULL,
  id_subject INT NOT NULL,
  id_lecturer INT NOT NULL,
  id_control_type INT NOT NULL,
  assessment_ects INT NOT NULL,
  assessment VARCHAR(1) NOT NULL)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS region (
  id_region INT NOT NULL auto_increment primary key,
  name_of_region VARCHAR(45) NOT NULL,
  code_region INT NOT NULL,
  UNIQUE INDEX code_region_UNIQUE (code_region ASC),
  UNIQUE INDEX name_of_region_UNIQUE (name_of_region ASC))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS town (
  id_town INT NOT NULL auto_increment primary key,
  id_region INT NOT NULL,
  town_name VARCHAR(45) NOT NULL,
  street_name VARCHAR(45) NOT NULL,
  streer_number INT NOT NULL)
ENGINE = InnoDB;

alter table chair add CONSTRAINT fk_chair_faculty FOREIGN KEY (id_faculty)
REFERENCES faculty (id_faculty) ON DELETE no action ON UPDATE no action;

alter table specialty add CONSTRAINT fk_specialty_chair FOREIGN KEY (id_chair)
REFERENCES chair (id_chair) ON DELETE no action ON UPDATE no action;

alter table groups add CONSTRAINT fk_groups_specialty FOREIGN KEY (id_speciality)
REFERENCES specialty (id_specialty) ON DELETE no action ON UPDATE no action;

alter table student add CONSTRAINT fk_student_scholarship FOREIGN KEY (id_scholarship)
REFERENCES scholarship (id_scholarship) ON DELETE no action ON UPDATE no action;

alter table student add CONSTRAINT fk_student_groups FOREIGN KEY (id_group) 
REFERENCES groups (id_group) ON DELETE no action ON UPDATE no action;

alter table student add CONSTRAINT fk_student_town FOREIGN KEY (id_town)
REFERENCES town (id_town) ON DELETE no action ON UPDATE no action;

alter table subject add CONSTRAINT fk_subject_semester FOREIGN KEY (id_semester)
REFERENCES semester (id_semester) ON DELETE no action ON UPDATE no action;

alter table lecturer_has_subject add CONSTRAINT fk_lecturer_has_subject_lecturer
FOREIGN KEY (id_lecturer) REFERENCES lecturer (id_lecturer)
ON DELETE no action ON UPDATE no action;

alter table lecturer_has_subject add CONSTRAINT fk_lecturer_has_subject_subject
FOREIGN KEY (id_subject) REFERENCES subject (id_subject)
ON DELETE no action ON UPDATE no action;

alter table session add CONSTRAINT fk_session_control_type FOREIGN KEY (id_control_type)
REFERENCES control_type (id_control_type) ON DELETE no action ON UPDATE no action;

alter table session add CONSTRAINT fk_session_lecturer FOREIGN KEY (id_lecturer)
REFERENCES lecturer (id_lecturer) ON DELETE no action ON UPDATE no action;

alter table session add CONSTRAINT fk_session_student FOREIGN KEY (id_student)
REFERENCES student (id_student) ON DELETE no action ON UPDATE no action;

alter table session add CONSTRAINT fk_session_subject FOREIGN KEY (id_subject)
REFERENCES subject (id_subject) ON DELETE no action ON UPDATE no action;

alter table town add CONSTRAINT fk_town_region FOREIGN KEY (id_region)
REFERENCES region (id_region) ON DELETE no action ON UPDATE no action;

insert into region values (1,'Львівська область', 2312);
insert into town values (1,1,'Львів','Шевченка',103);
insert into scholarship values (1,1300);
insert into faculty values (1,'Програмна інженерія');
insert into chair values (1,'Програмне забезпечення',1);
insert into specialty values (1,1,'Програмна інженерія','6.050103');
insert into groups values (1,'ПІ',11,25,1);
insert into student values (1,'Янко','Андрій','Володимирович',null,null,'1996-05-21','2013-09-01',12131,87.5,'mde12@gmail.com',380639281703,null,1,1,1);
insert into semester values (1,1);
insert into subject values (1,'Основи програмування',1);
insert into lecturer values (1,'Сенів','Максим','seniv@gmail.com',null);
insert lecturer_has_subject values (1,1);
insert into control_type values (1,'екзамен');
insert into session values (1,'2018-01-15',1,1,1,1,88,'A');
