package org.example.model;

import java.util.HashSet;
import java.util.Set;

public class University {
    private int id;
    private String name;
    private Set<Student> students = new HashSet<>();
}
