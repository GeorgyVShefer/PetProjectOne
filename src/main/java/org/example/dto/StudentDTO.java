package org.example.dto;

import lombok.*;
import org.example.model.Course;
import org.example.model.University;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class StudentDTO {
    private int id;
    private String name;
    private University university;
    private Set<Course> courses = new HashSet<>();
}
