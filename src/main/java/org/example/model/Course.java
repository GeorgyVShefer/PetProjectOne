package org.example.model;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Course {
    private int id;
    private String title;
    private Set<Student> students = new HashSet<>();
}
