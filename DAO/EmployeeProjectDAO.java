package DAO;
import DButil.DatabaseConnection;
import Service.EmployeeProjectServices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class EmployeeProjectDAO {
    public EmployeeProjectDAO(Connection connection) {

    }

    public EmployeeProjectDAO() {

    }

    public void addEmployeeProject(int employeeId, int projectId) throws SQLException {
        String sql = "INSERT INTO employee_projects (employee_id, project_id) VALUES (?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, employeeId);
            statement.setInt(2, projectId);
            statement.executeUpdate();
        }
    }

    public List<Integer> getProjectsByEmployee(int employeeId) throws SQLException {
        List<Integer> projectIds = new ArrayList<>();
        String sql = "SELECT project_id FROM employee_projects WHERE employee_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, employeeId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                projectIds.add(resultSet.getInt("project_id"));
            }
        }
        return projectIds;
    }

    public List<Integer> getEmployeesByProject(int projectId) throws SQLException {
        List<Integer> employeeIds = new ArrayList<>();
        String sql = "SELECT employee_id FROM employee_projects WHERE project_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, projectId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                employeeIds.add(resultSet.getInt("employee_id"));
            }
        }
        return employeeIds;
    }

    public void deleteEmployeeProject(int employeeId, int projectId) throws SQLException {
        String sql = "DELETE FROM employee_projects WHERE employee_id = ? AND project_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, employeeId);
            statement.setInt(2, projectId);
            statement.executeUpdate();
        }
    }

    public List<Integer> getProjectsByEmployeeId(int employeeId) {
        return null;
    }

    public List<EmployeeProjectServices> getAllEmployeeProjects() {
        return null;
    }
}