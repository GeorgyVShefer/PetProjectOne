package org.example.service;

import org.example.dao.StudentDAO;
import org.example.dto.StudentDTO;
import org.example.model.Student;

import java.util.List;

public class StudentService {
    StudentDAO studentDAO;
    Student student = new Student();
    public StudentService(StudentDAO studentDAO){
        this.studentDAO = studentDAO;
    }
    public void save(int id, String title){
        StudentDTO studentDTO = mapToDTO(student);
        studentDAO.saveStudent(studentDTO.getId(),studentDTO.getName());
    }
    public List<Student> get(){
        return studentDAO.getAllStudents();
    }
    public void update(int id, String title ){
        StudentDTO studentDTO = mapToDTO(student);
        studentDAO.updateStudent(studentDTO.getId(),studentDTO.getName());
    }
    public void delete(int id){
        StudentDTO studentDTO = mapToDTO(student);
        studentDAO.deleteStudent(studentDTO.getId());
    }

    private StudentDTO mapToDTO(Student student){
        if (student == null) {
            return null;
        }
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(studentDTO.getName());
        return studentDTO;
    }
}
