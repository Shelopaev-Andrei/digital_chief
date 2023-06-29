CREATE TABLE `educationalinstitution`.`faculty`
(
    `id_faculty`                 INT         NOT NULL AUTO_INCREMENT,
    `name_faculty`               VARCHAR(45) NOT NULL,
    `department`                 VARCHAR(45) NULL,
    `number_of_students_faculty` INT         NULL,
    `number_of_teachers_faculty` INT         NULL,
    `gpa_faculty`                DOUBLE      NULL,
    `id_university`              INT         NULL,
    PRIMARY KEY (`id_faculty`),
    INDEX `id_university_idx` (`id_university` ASC) VISIBLE,
    CONSTRAINT `id_university`
        FOREIGN KEY (`id_university`)
            REFERENCES `educationalinstitution`.`university` (`id_university`)
            ON DELETE NO ACTION
            ON UPDATE CASCADE
);
insert into educationalinstitution.faculty (name_faculty,
                                            department,
                                            number_of_students_faculty,
                                            number_of_teachers_faculty,
                                            gpa_faculty,
                                            id_university)
values ('Biology', 'Chemistry', 418, 40, 7.2, 1);
insert into educationalinstitution.faculty (name_faculty,
                                            department,
                                            number_of_students_faculty,
                                            number_of_teachers_faculty,
                                            gpa_faculty,
                                            id_university)
values ('Filology', 'Belarusian language', 321, 38, 7.5, 1);
