package com.example.digitalchief.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "university")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_university", nullable = false)
    private Long idUniversity;
    @Column(name = "name_university")
    private String nameUniversity;
    @Column(name = "number_of_students_university")
    private int numberOfStudentsUniversity;
    @Column(name = "number_of_teachers_university")
    private int numberOfTeachersUniversity;
    @Column(name = "grade_point_average_university")
    private double gpaUniversity;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "university")
    private List<Faculty> facultyList;

    public void setFaculty(List<Faculty> facultyList) {
        if (facultyList != null) {
            facultyList.forEach(f -> f.setUniversity(this));
        }
        this.facultyList = facultyList;
    }

}
