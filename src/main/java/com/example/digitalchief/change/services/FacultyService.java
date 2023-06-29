package com.example.digitalchief.change.services;

import com.example.digitalchief.change.dto.FacultyDto;
import com.example.digitalchief.entity.Faculty;

import java.util.List;

public interface FacultyService {

    Faculty createFaculty(FacultyDto dto);

    List<Faculty> getAllFaculty();

    Faculty getFacultyById(Long id);

    Faculty updateFaculty(FacultyDto dto);

    void deleteFaculty(Long id);

}
