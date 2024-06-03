package Models;
import java.sql.Date;

public class Employee {
    private int id;
    private String name;
    private int departmentId;
    private int jobId;
    private String email;
    private Date hireDate;

    public Employee(int id, String name, int departmentId, int jobId, String email, Date hireDate) {
        this.id = id;
        this.name = name;
        this.departmentId = departmentId;
        this.jobId = jobId;
        this.email = email;
        this.hireDate = hireDate;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", departmentId=" + departmentId +
                ", jobId=" + jobId +
                ", email='" + email + '\'' +
                ", hireDate=" + hireDate +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
}
