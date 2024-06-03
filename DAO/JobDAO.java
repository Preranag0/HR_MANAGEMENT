package DAO;
import DButil.DatabaseConnection;
import Models.Job;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class JobDAO {
    public JobDAO(Connection connection) {

    }

    public JobDAO() {

    }

    public void addJob(Job job) throws SQLException {
        String sql = "INSERT INTO jobs (title, min_salary, max_salary) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, job.getTitle());
            statement.setBigDecimal(2, job.getMinSalary());
            statement.setBigDecimal(3, job.getMaxSalary());
            statement.executeUpdate();
        }
    }

    public Job getJob(int id) throws SQLException {
        String sql = "SELECT * FROM jobs WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Job(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getBigDecimal("min_salary"),
                        resultSet.getBigDecimal("max_salary")
                );
            }
        }
        return null;
    }

    public List<Job> getAllJobs() throws SQLException {
        List<Job> jobs = new ArrayList<>();
        String sql = "SELECT * FROM jobs";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                jobs.add(new Job(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getBigDecimal("min_salary"),
                        resultSet.getBigDecimal("max_salary")
                ));
            }
        }
        return jobs;
    }

    public void updateJob(Job job) throws SQLException {
        String sql = "UPDATE jobs SET title = ?, min_salary = ?, max_salary = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, job.getTitle());
            statement.setBigDecimal(2, job.getMinSalary());
            statement.setBigDecimal(3, job.getMaxSalary());
            statement.setInt(4, job.getId());
            statement.executeUpdate();
        }
    }

    public void deleteJob(int id) throws SQLException {
        String sql = "DELETE FROM jobs WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
