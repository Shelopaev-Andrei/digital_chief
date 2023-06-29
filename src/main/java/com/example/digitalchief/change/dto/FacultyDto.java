package com.example.digitalchief.change.dto;

import lombok.Data;

@Data
public class FacultyDto {

    private Long idFaculty;
    private String nameFaculty;
    private String department;
    private int numberOfStudentsFaculty;
    private int numberOfTeachersFaculty;
    private double gpaFaculty;

    private Long idUniversity;


}
