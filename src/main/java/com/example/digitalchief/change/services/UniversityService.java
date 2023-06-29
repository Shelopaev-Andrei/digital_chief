package com.example.digitalchief.change.services;

import com.example.digitalchief.change.dto.UniversityDto;
import com.example.digitalchief.entity.University;

import java.util.List;

public interface UniversityService {
    University createUniversity(UniversityDto dto);

    List<University> getAllUniversity();

    University getUniversityById(Long id);

    University updateUniversity(UniversityDto dto);

    void deleteUniversity(Long id);
}
