package com.example.digitalchief.change.controllers;

import com.example.digitalchief.change.dto.FacultyDto;
import com.example.digitalchief.change.services.FacultyService;
import com.example.digitalchief.entity.Faculty;
import com.example.digitalchief.error.AppError;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faculties")
@Api(value = "faculty resources", description = "crud operation")
public class FacultyController {

    private final FacultyService facultyService;

    @Autowired
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping("/")
    @ApiOperation(value = "Creation of a faculty", response = ResponseEntity.class)
    public ResponseEntity<Faculty> createFaculty(@RequestBody FacultyDto dto) {
        return new ResponseEntity<>(facultyService.createFaculty(dto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Getting a list of faculties", response = List.class)
    public ResponseEntity<List<Faculty>> getAllFaculty() {
        return new ResponseEntity<>(facultyService.getAllFaculty(), HttpStatus.OK);
    }

    @PutMapping("/")
    @ApiOperation(value = "Faculty data update")
    public ResponseEntity<?> updateFaculty(@RequestBody FacultyDto dto) {
        try {
            return new ResponseEntity<>(facultyService.updateFaculty(dto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    "Invalid request data"), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleting a Faculty")
    public ResponseEntity<?> deleteFacultyById(@PathVariable("id") Long id) {
        try {
            if (id < 1) {
                return ResponseEntity.badRequest().body("Invalid id");
            } else {
                facultyService.deleteFaculty(id);
                return new ResponseEntity<>(new AppError(HttpStatus.OK.value(), "Faculty removed"), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    "Faculty with id " + id + " not found"), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Faculty search by ID")
    public ResponseEntity<?> getFacultyById(@PathVariable("id") Long id) {
        try {
            if (id < 1) {
                return ResponseEntity.badRequest().body("Invalid id");
            } else {
                return new ResponseEntity<>(facultyService.getFacultyById(id), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    "Faculty with id " + id + " not found"), HttpStatus.NOT_FOUND);
        }
    }

}
