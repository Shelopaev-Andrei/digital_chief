package com.example.digitalchief.change.dto;

import com.example.digitalchief.entity.Faculty;
import lombok.Data;

import java.util.List;

@Data
public class UniversityDto {

    private Long idUniversity;
    private String nameUniversity;
    private int numberOfStudentsUniversity;
    private int numberOfTeachersUniversity;
    private double gpaUniversity;
    private List<Faculty> facultyList;





}
