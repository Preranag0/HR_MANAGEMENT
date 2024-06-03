package Service;

import DAO.JobDAO;
import Models.Job;

import java.sql.*;
import java.util.*;


public class JobServices {
    private JobDAO jobDAO;

    public JobServices(Connection connection) {
        this.jobDAO = new JobDAO(connection);
    }

    public void addJob(Job job) throws SQLException {
        jobDAO.addJob(job);
    }

    public Job getJob(int id) throws SQLException {
        return jobDAO.getJob(id);
    }

    public void updateJob(Job job) throws SQLException {
        jobDAO.updateJob(job);
    }

    public void deleteJob(int id) throws SQLException {
        jobDAO.deleteJob(id);
    }

    public List<Job> getAllJobs() throws SQLException {
        return jobDAO.getAllJobs();
}

}
