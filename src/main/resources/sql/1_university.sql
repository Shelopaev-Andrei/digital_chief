CREATE SCHEMA `educationalinstitution`;

CREATE TABLE educationalinstitution.university
(
    `id_university`                  int         NOT NULL AUTO_INCREMENT,
    `name_university`                varchar(45) NOT NULL,
    `number_of_teachers_university`  int    DEFAULT NULL,
    `number_of_students_university`  int    DEFAULT NULL,
    `grade_point_average_university` double DEFAULT NULL,
    PRIMARY KEY (`id_university`)

);

insert into educationalinstitution.university (
    name_university,
    number_of_students_university,
    number_of_teachers_university,
    grade_point_average_university) values ('GGU Scorina', 5508, 1422, 6.8);

insert into educationalinstitution.university (
    name_university,
    number_of_students_university,
    number_of_teachers_university,
    grade_point_average_university) values ('Suhogo', 4500 , 250, 6.3);

#   CONSTRAINT `faculty_id` FOREIGN KEY (`faculty_id`)
#   REFERENCES `faculty` (`id_faculty`)
#   KEY `faculty_id` (`faculty_id`),
#     ON DELETE CASCADE ON UPDATE CASCADE