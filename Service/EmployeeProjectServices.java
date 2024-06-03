package Service;

import DAO.EmployeeProjectDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmployeeProjectServices {
    private EmployeeProjectDAO employeeProjectDAO;

    public EmployeeProjectServices(Connection connection) {
        this.employeeProjectDAO = new EmployeeProjectDAO(connection);
    }

    public void addEmployeeProject(int employeeId, int projectId) throws SQLException {
        employeeProjectDAO.addEmployeeProject(employeeId, projectId);
    }

    public List<Integer> getProjectsByEmployeeId(int employeeId) throws SQLException {
        return employeeProjectDAO.getProjectsByEmployeeId(employeeId);
    }

    public void deleteEmployeeProject(int employeeId, int projectId) throws SQLException {
        employeeProjectDAO.deleteEmployeeProject(employeeId, projectId);
    }

    public List<EmployeeProjectServices> getAllEmployeeProjects() throws SQLException {
        return employeeProjectDAO.getAllEmployeeProjects();
}

}
