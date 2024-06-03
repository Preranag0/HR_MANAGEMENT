package DAO;
import DButil.DatabaseConnection;
import Models.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
public class ProjectDAO {
    public ProjectDAO(Connection connection) {

    }

    public ProjectDAO() {

    }

    public void addProject(Project project) throws SQLException {
        String sql = "INSERT INTO projects (name, start_date, end_date) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, project.getName());
            statement.setDate(2, project.getStartDate());
            statement.setDate(3, project.getEndDate());
            statement.executeUpdate();
        }
    }

    public Project getProject(int id) throws SQLException {
        String sql = "SELECT * FROM projects WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Project(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDate("start_date"),
                        resultSet.getDate("end_date")
                );
            }
        }
        return null;
    }

    public List<Project> getAllProjects() throws SQLException {
        List<Project> projects = new ArrayList<>();
        String sql = "SELECT * FROM projects";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                projects.add(new Project(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDate("start_date"),
                        resultSet.getDate("end_date")
                ));
            }
        }
        return projects;
    }

    public void updateProject(Project project) throws SQLException {
        String sql = "UPDATE projects SET name = ?, start_date = ?, end_date = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, project.getName());
            statement.setDate(2, project.getStartDate());
            statement.setDate(3, project.getEndDate());
            statement.setInt(4, project.getId());
            statement.executeUpdate();
        }
    }

    public void deleteProject(int id) throws SQLException {
        String sql = "DELETE FROM projects WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
