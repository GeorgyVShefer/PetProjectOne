package org.example.dao;

import org.example.model.Student;
import org.example.model.University;
import org.example.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public void saveStudent(int id, String name){
        try(Connection connection = JDBCUtil.getConnection()){
            String sql = "INSERT INTO student VALUES(id, name) = (?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, name);

            statement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();
        try (Connection connection = JDBCUtil.getConnection()){
            String sql = "SELECT s.*, u.* FROM student s " +
                    "JOIN university u ON s.university_id = u.id";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getInt("s.id"));
                student.setName(resultSet.getString("s.name"));
                University university = new University();
                university.setId(resultSet.getInt("u.id"));
                university.setName(resultSet.getString("u.name"));
                student.setUniversity(university);
                students.add(student);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }
    public void updateStudent(int id, String name){
        try (Connection connection = JDBCUtil.getConnection()){
            String sql = "UPDATE student SET name = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, id);

            statement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteStudent(int id){
        try (Connection connection = JDBCUtil.getConnection()){
            String sql = "DELETE FROM student WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            statement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
