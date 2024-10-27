package org.example.dao;

import org.example.model.University;
import org.example.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UniversityDAO {
    public void saveUniversity(int id, String name){
        try(Connection connection = JDBCUtil.getConnection()){
            String sql = "INSERT INTO university VALUES(id, name) = (?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, name);

            statement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public University getUniversity(){
        University university = new University();
        try (Connection connection = JDBCUtil.getConnection()){
            String sql = "SELECT * FROM university";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                university.setId(resultSet.getInt("id"));
                university.setName(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return university;
    }
    public void updateUniversity(int id, String name){
        try (Connection connection = JDBCUtil.getConnection()){
            String sql = "UPDATE university SET name = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, id);

            statement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteUniversity(int id){
        try (Connection connection = JDBCUtil.getConnection()){
            String sql = "DELETE FROM university WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            statement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
