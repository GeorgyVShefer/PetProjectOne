package org.example.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.dao.CourseDAO;
import org.example.dto.CourseDTO;
import org.example.model.Course;

import java.util.List;

@NoArgsConstructor
public class CourseService {
    private CourseDAO courseDAO;
    private Course course;
    public CourseService(CourseDAO courseDAO){
        this.courseDAO = courseDAO;
    }

    public void save(int id, String name ){
        CourseDTO courseDTO = mapToDTO(course);
        courseDAO.saveCourse(courseDTO.getId(),courseDTO.getTitle());
    }
    //Должен возвращать список CourseDTO
    //Смапить модель курс в courseDTO
    public List<Course> get(){

        return  courseDAO.getAll();
    }
    public CourseDTO getCourseById(int id){
        Course courseById = courseDAO.getCourseById(id);
        return mapToDTO(courseById);
    }
    public void update(int id, String title ){
        CourseDTO courseDTO = mapToDTO(course);
        courseDAO.updateCourse(courseDTO.getId(),courseDTO.getTitle());
    }
    public void delete(int id){
        CourseDTO courseDTO = mapToDTO(course);
        courseDAO.deleteCourse(courseDTO.getId());
    }

    private CourseDTO mapToDTO(Course course){
        if(course == null){
            return null;
        }
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setTitle(course.getTitle());
        return courseDTO;
    }
}
