package com.example.digitalchief.change.services;

import com.example.digitalchief.change.dao.UniversityRepository;
import com.example.digitalchief.change.dto.UniversityDto;
import com.example.digitalchief.entity.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UniversityServiceImpl implements UniversityService {
    private final UniversityRepository universityRepository;

    @Autowired
    public UniversityServiceImpl(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @Override
    public University createUniversity(UniversityDto dto) {
        University university = getUniversity(dto);
        return universityRepository.save(university);
    }

    @Override
    public List<University> getAllUniversity() {
        return universityRepository.findAll();
    }

    @Override
    public University getUniversityById(Long id) {
        return universityRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("University not found - " + id));
    }

    @Override
    public University updateUniversity(UniversityDto dto){
        University university = getUniversity(dto);
        university.setIdUniversity(dto.getIdUniversity());
        return universityRepository.save(university);
    }

    @Override
    public void deleteUniversity(Long id) {
        universityRepository.deleteById(id);
    }

    private University getUniversity(UniversityDto dto) {
        University university = new University();
        university.setNameUniversity(dto.getNameUniversity());
        university.setNumberOfStudentsUniversity(dto.getNumberOfStudentsUniversity());
        university.setNumberOfTeachersUniversity(dto.getNumberOfTeachersUniversity());
        university.setGpaUniversity(dto.getGpaUniversity());
        return university;
    }
}
