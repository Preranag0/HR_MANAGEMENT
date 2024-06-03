package Service;

import DAO.DepartmentDAO;
import Models.Department;

import java.sql.*;
import java.util.*;


public class DepartmentServices {
    private DepartmentDAO departmentDAO;

    public DepartmentServices(Connection connection) {
        this.departmentDAO = new DepartmentDAO(connection);
    }

    public void addDepartment(Department department) throws SQLException {
        departmentDAO.addDepartment(department);
    }

    public Department getDepartment(int id) throws SQLException {
        return departmentDAO.getDepartment(id);
    }

    public void updateDepartment(Department department) throws SQLException {
        departmentDAO.updateDepartment(department);
    }

    public void deleteDepartment(int id) throws SQLException {
        departmentDAO.deleteDepartment(id);
    }

    public List<Department> getAllDepartments() throws SQLException {
        return departmentDAO.getAllDepartments();
}

}
