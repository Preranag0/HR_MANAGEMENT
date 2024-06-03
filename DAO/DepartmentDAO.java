package DAO;
import DButil.DatabaseConnection;
import Models.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class DepartmentDAO {
    public DepartmentDAO(Connection connection) {

    }

    public DepartmentDAO() {

    }

    public void addDepartment(Department department) throws SQLException {
        String sql = "INSERT INTO departments (name) VALUES (?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, department.getName());
            statement.executeUpdate();
        }
    }

    public Department getDepartment(int id) throws SQLException {
        String sql = "SELECT * FROM departments WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Department(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
            }
        }
        return null;
    }

    public List<Department> getAllDepartments() throws SQLException {
        List<Department> departments = new ArrayList<>();
        String sql = "SELECT * FROM departments";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                departments.add(new Department(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                ));
            }
        }
        return departments;
    }

    public void updateDepartment(Department department) throws SQLException {
        String sql = "UPDATE departments SET name = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, department.getName());
            statement.setInt(2, department.getId());
            statement.executeUpdate();
        }
    }

    public void deleteDepartment(int id) throws SQLException {
        String sql = "DELETE FROM departments WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
