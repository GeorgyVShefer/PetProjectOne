package org.example.model;

import java.util.HashSet;
import java.util.Set;

public class Course {
    private int id;
    private String title;
    private Set<Student> students = new HashSet<>();
}
