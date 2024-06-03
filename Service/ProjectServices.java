package Service;

import DAO.ProjectDAO;
import Models.Project;

import java.sql.*;
import java.util.*;


public class ProjectServices {
    private ProjectDAO projectDAO;

    public ProjectServices(Connection connection) {
        this.projectDAO = new ProjectDAO(connection);
    }

    public void addProject(Project project) throws SQLException {
        projectDAO.addProject(project);
    }

    public Project getProject(int id) throws SQLException {
        return projectDAO.getProject(id);
    }

    public void updateProject(Project project) throws SQLException {
        projectDAO.updateProject(project);
    }

    public void deleteProject(int id) throws SQLException {
        projectDAO.deleteProject(id);
    }

    public List<Project> getAllProjects() throws SQLException {
        return projectDAO.getAllProjects();
}

}
