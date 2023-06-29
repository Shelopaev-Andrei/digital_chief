package com.example.digitalchief.change.services;

import com.example.digitalchief.change.dao.FacultyRepository;
import com.example.digitalchief.change.dto.FacultyDto;
import com.example.digitalchief.entity.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;
    private final UniversityService universityService;

    @Autowired
    public FacultyServiceImpl(FacultyRepository facultyRepository, UniversityService universityService) {
        this.facultyRepository = facultyRepository;
        this.universityService = universityService;
    }

    @Override
    public Faculty createFaculty(FacultyDto dto) {
        Faculty faculty = getFaculty(dto);
        return facultyRepository.save(faculty);
    }

    @Override
    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty getFacultyById(Long id) {
        return facultyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Faculty not found - " + id));
    }

    @Override
    public Faculty updateFaculty(FacultyDto dto) {
        Faculty faculty = getFaculty(dto);
        faculty.setIdFaculty(dto.getIdFaculty());
        return facultyRepository.save(faculty);
    }

    @Override
    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }

    private Faculty getFaculty(FacultyDto dto) {
        Faculty faculty = new Faculty();
        faculty.setNameFaculty(dto.getNameFaculty());
        faculty.setDepartment(dto.getDepartment());
        faculty.setNumberOfStudentsFaculty(dto.getNumberOfStudentsFaculty());
        faculty.setNumberOfTeachersFaculty(dto.getNumberOfTeachersFaculty());
        faculty.setGpaFaculty(dto.getGpaFaculty());
        faculty.setUniversity(universityService.getUniversityById(dto.getIdUniversity()));
        return faculty;
    }
}
