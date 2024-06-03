package DAO;
import DButil.DatabaseConnection;
import Models.Employee;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
public class EmployeeDAO {
    public void addEmployee(Employee employee) throws SQLException {
        String sql = "INSERT INTO employees (name, department_id, job_id, email, hire_date) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, employee.getName());
            statement.setInt(2, employee.getDepartmentId());
            statement.setInt(3, employee.getJobId());
            statement.setString(4, employee.getEmail());
            statement.setDate(5, employee.getHireDate());
            statement.executeUpdate();
        }
    }

    public Employee getEmployee(int id) throws SQLException {
        String sql = "SELECT * FROM employees WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Employee(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("department_id"),
                        resultSet.getInt("job_id"),
                        resultSet.getString("email"),
                        resultSet.getDate("hire_date")
                );
            }
        }
        return null;
    }

    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                employees.add(new Employee(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("department_id"),
                        resultSet.getInt("job_id"),
                        resultSet.getString("email"),
                        resultSet.getDate("hire_date")

                ));
            }
        }
        return employees;
    }

    public void updateEmployee(Employee employee) throws SQLException {
        String sql = "UPDATE employees SET name = ?, department_id = ?, job_id = ?, email = ?, hire_date = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, employee.getName());
            statement.setInt(2, employee.getDepartmentId());
            statement.setInt(3, employee.getJobId());
            statement.setString(4, employee.getEmail());
            statement.setDate(5, employee.getHireDate());
            statement.setInt(6, employee.getId());
            statement.executeUpdate();
        }
    }

    public void deleteEmployee(int id) throws SQLException {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
