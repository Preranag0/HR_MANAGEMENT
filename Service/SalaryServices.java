package Service;

import DAO.SalaryDAO;
import Models.Salary;

import java.sql.*;
import java.util.*;

public class SalaryServices {
    private SalaryDAO salaryDAO;

    public SalaryServices(Connection connection) {
        this.salaryDAO = new SalaryDAO(connection);
    }

    public void addSalary(Salary salary) throws SQLException {
        salaryDAO.addSalary(salary);
    }

    public Salary getSalary(int id) throws SQLException {
        return salaryDAO.getSalary(id);
    }

    public void updateSalary(Salary salary) throws SQLException {
        salaryDAO.updateSalary(salary);
    }

    public void deleteSalary(int id) throws SQLException {
        salaryDAO.deleteSalary(id);
    }

    public List<Salary> getAllSalaries() throws SQLException {
        return salaryDAO.getAllSalaries();
}

}
