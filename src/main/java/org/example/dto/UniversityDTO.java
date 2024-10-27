package org.example.dto;

import lombok.*;
import org.example.model.Student;
import org.example.model.University;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UniversityDTO extends University {
    private int id;
    private String name;
    private Set<Student> students = new HashSet<>();
}
