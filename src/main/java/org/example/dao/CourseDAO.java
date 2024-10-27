package org.example.dao;



import org.example.model.Course;
import org.example.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO{

    public void saveCourse(int id, String title){
        try(Connection connection = JDBCUtil.getConnection()){
            String sql = "INSERT INTO course VALUES(id, title) = (?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, title);

            statement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //Создать приватный метод для получения данных из resultSet

    public List<Course> getAll(){
        List<Course> courses = new ArrayList<>();
        try (Connection connection = JDBCUtil.getConnection()){
            String sql = "SELECT * FROM course";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Course course = new Course();
                course.setId(resultSet.getInt("id"));
                course.setTitle(resultSet.getString("title"));
                courses.add(course);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return courses;
    }
    public Course getCourseById(int id){
        Course course = new Course();
        try (Connection connection = JDBCUtil.getConnection()){
            String sql = "SELECT title FROM course WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                course.setId(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return course;
    }
    public void updateCourse(int id, String title){
        try (Connection connection = JDBCUtil.getConnection()){
            String sql = "UPDATE course SET title = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, title);
            statement.setInt(2, id);

            statement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteCourse(int id){
        try (Connection connection = JDBCUtil.getConnection()){
            String sql = "DELETE FROM course WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            statement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

