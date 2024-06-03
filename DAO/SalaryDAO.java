package DAO;
import DButil.DatabaseConnection;
import Models.Salary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
public class SalaryDAO {
    public SalaryDAO(Connection connection) {

    }

    public SalaryDAO() {

    }

    public void addSalary(Salary salary) throws SQLException {
        String sql = "INSERT INTO salaries (employee_id, amount, effective_date) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, salary.getEmployeeId());
            statement.setBigDecimal(2, salary.getAmount());
            statement.setDate(3, salary.getEffectiveDate());
            statement.executeUpdate();
        }
    }

    public Salary getSalary(int id) throws SQLException {
        String sql = "SELECT * FROM salaries WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Salary(
                        resultSet.getInt("id"),
                        resultSet.getInt("employee_id"),
                        resultSet.getBigDecimal("amount"),
                        resultSet.getDate("effective_date")
                );
            }
        }
        return null;
    }

    public List<Salary> getAllSalaries() throws SQLException {
        List<Salary> salaries = new ArrayList<>();
        String sql = "SELECT * FROM salaries";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                salaries.add(new Salary(
                        resultSet.getInt("id"),
                        resultSet.getInt("employee_id"),
                        resultSet.getBigDecimal("amount"),
                        resultSet.getDate("effective_date")
                ));
            }
        }
        return salaries;
    }

    public void updateSalary(Salary salary) throws SQLException {
        String sql = "UPDATE salaries SET employee_id = ?, amount = ?, effective_date = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, salary.getEmployeeId());
            statement.setBigDecimal(2, salary.getAmount());
            statement.setDate(3, salary.getEffectiveDate());
            statement.setInt(4, salary.getId());
            statement.executeUpdate();
        }
    }

    public void deleteSalary(int id) throws SQLException {
        String sql = "DELETE FROM salaries WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
