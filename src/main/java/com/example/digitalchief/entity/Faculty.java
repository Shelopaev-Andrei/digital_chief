package com.example.digitalchief.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "faculty")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_faculty", nullable = false)
    private Long idFaculty;
    @Column(name = "name_faculty")
    private String nameFaculty;
    @Column(name = "department")
    private String department;
    @Column(name = "number_of_students_faculty")
    private int numberOfStudentsFaculty;
    @Column(name = "number_of_teachers_faculty")
    private int numberOfTeachersFaculty;
    @Column(name = "gpa_faculty")
    private double gpaFaculty;
    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "id_university")
    private University university;

}
