package Service;
import DAO.EmployeeDAO;
import Models.Employee;

import java.sql.SQLException;
import java.util.List;

public class EmployeeServices {
    private EmployeeDAO employeeDAO;

    public EmployeeServices() {
        employeeDAO = new EmployeeDAO();
    }

    public void addEmployee(Employee employee) throws SQLException {
        employeeDAO.addEmployee(employee);
    }

    public List<Employee> getAllEmployees() throws SQLException {
        return employeeDAO.getAllEmployees();
    }

    public void updateEmployee(Employee employee) throws SQLException {
        employeeDAO.updateEmployee(employee);
    }

    public void deleteEmployee(int id) throws SQLException {
        employeeDAO.deleteEmployee(id);
    }
}

