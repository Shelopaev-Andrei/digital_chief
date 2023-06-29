package com.example.digitalchief.change.controllers;

import com.example.digitalchief.change.dto.UniversityDto;
import com.example.digitalchief.change.services.UniversityService;
import com.example.digitalchief.entity.University;
import com.example.digitalchief.error.AppError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/universities")
public class UniversityController {
    private final UniversityService universityService;

    @Autowired
    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @PostMapping("/")
    public ResponseEntity<University> createUniversity(@RequestBody UniversityDto dto) {
        return new ResponseEntity<>(universityService.createUniversity(dto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<University>> getAllUniversity() {
        return new ResponseEntity<>(universityService.getAllUniversity(), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<?> updateUniversity(@RequestBody UniversityDto dto) {
        try {
            return new ResponseEntity<>(universityService.updateUniversity(dto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    "Invalid request data"), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUniversity(@PathVariable("id") Long id) {
        try {
            if (id < 1) {
                return ResponseEntity.badRequest().body("Invalid id");
            } else {
                universityService.deleteUniversity(id);
                return new ResponseEntity<>(new AppError(HttpStatus.OK.value(), "University removed"), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    "University with id " + id + " not found"), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUniversityById(@PathVariable("id") Long id) {
        try {
            if (id < 1) {
                return ResponseEntity.badRequest().body("Invalid id");
            } else {
                return new ResponseEntity<>(universityService.getUniversityById(id), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    "University with id " + id + " not found"), HttpStatus.NOT_FOUND);
        }
    }
}