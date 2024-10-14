package org.example.dto;

import lombok.*;
import org.example.model.Student;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CourseDTO {
    private int id;
    private String title;
    private Set<Student> students = new HashSet<>();
}
