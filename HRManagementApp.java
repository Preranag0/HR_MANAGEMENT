import DAO.*;
import Models.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class HRManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeDAO employeeDAO = new EmployeeDAO();
        DepartmentDAO departmentDAO = new DepartmentDAO();
        JobDAO jobDAO = new JobDAO();
        SalaryDAO salaryDAO = new SalaryDAO();
        ProjectDAO projectDAO = new ProjectDAO();
        EmployeeProjectDAO employeeProjectDAO = new EmployeeProjectDAO();

        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. Get Employee by ID");
            System.out.println("3. Get All Employees");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
//            System.out.println("6. Add Department");
////            System.out.println("7. Get Department by ID");
//            System.out.println("8. Get All Departments");8
//            System.out.println("9. Update Department");
//            System.out.println("10. Delete Department");
            System.out.println("6. Add Job");
            System.out.println("7. Get Job by ID");
            System.out.println("8. Get All Jobs");
//            System.out.println("14. Update Job");
            System.out.println("9. Delete Job");
            System.out.println("10. Add Salary");
            System.out.println("11. Get Salary by ID");
            System.out.println("12. Get All Salaries");
//            System.out.println("19. Update Salary");
            System.out.println("13. Delete Salary");
            System.out.println("14. Add Project");
            System.out.println("15. Get Project by ID");
            System.out.println("16. Get All Projects");
//            System.out.println("24. Update Project");
            System.out.println("17. Delete Project");
            System.out.println("18. Add Employee to Project");
//            System.out.println("27. Get Projects by Employee ID");
//            System.out.println("28. Get Employees by Project ID");
//            System.out.println("29. Delete Employee from Project");
            System.out.println("19. Exit");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        // Add Employee
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter department ID: ");
                        int departmentId = scanner.nextInt();
                        System.out.print("Enter job ID: ");
                        int jobId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter email: ");
                        String email = scanner.nextLine();
                        System.out.print("Enter hire date (yyyy-mm-dd): ");
                        String hireDateStr = scanner.nextLine();
                        Date hireDate = Date.valueOf(hireDateStr);

                        Employee employee = new Employee(0, name, departmentId, jobId, email, hireDate);
                        employeeDAO.addEmployee(employee);
                        System.out.println("Employee added successfully.");
                        break;

                    case 2:
                        // Get Employee by ID
                        System.out.print("Enter employee ID: ");
                        int empId = scanner.nextInt();
                        Employee emp = employeeDAO.getEmployee(empId);
                        if (emp != null) {
                            System.out.println("ID: " + emp.getId());
                            System.out.println("Name: " + emp.getName());
                            System.out.println("Department ID: " + emp.getDepartmentId());
                            System.out.println("Job ID: " + emp.getJobId());
                            System.out.println("Email: " + emp.getEmail());
                            System.out.println("Hire Date: " + emp.getHireDate());
                        } else {
                            System.out.println("Employee not found.");
                        }
                        break;

                    case 3:
                        // Get All Employees
                        List<Employee> employees = employeeDAO.getAllEmployees();
                        for (Employee e : employees) {
                            System.out.println("ID: " + e.getId());
                            System.out.println("Name: " + e.getName());
                            System.out.println("Department ID: " + e.getDepartmentId());
                            System.out.println("Job ID: " + e.getJobId());
                            System.out.println("Email: " + e.getEmail());
                            System.out.println("Hire Date: " + e.getHireDate());
                        }
                        break;

                    case 4:
                        // Update Employee
                        System.out.print("Enter employee ID to update: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new department ID: ");
                        int newDepartmentId = scanner.nextInt();
                        System.out.print("Enter new job ID: ");
                        int newJobId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter new email: ");
                        String newEmail = scanner.nextLine();
                        System.out.print("Enter new hire date (yyyy-mm-dd): ");
                        String newHireDateStr = scanner.nextLine();
                        Date newHireDate = Date.valueOf(newHireDateStr);

                        Employee updatedEmployee = new Employee(updateId, newName, newDepartmentId, newJobId, newEmail, newHireDate);
                        employeeDAO.updateEmployee(updatedEmployee);
                        System.out.println("Employee updated successfully.");
                        break;

                    case 5:
                        // Delete Employee
                        System.out.print("Enter employee ID to delete: ");
                        int deleteEmpId = scanner.nextInt();
                        employeeDAO.deleteEmployee(deleteEmpId);
                        System.out.println("Employee deleted successfully.");
                        break;

//                    case 6:
//                        // Add Department
//                        System.out.print("Enter department name: ");
//                        String deptName = scanner.nextLine();
//                        Department department = new Department(0, deptName);
//                        departmentDAO.addDepartment(department);
//                        System.out.println("Department added successfully.");
//                        break;

//                    case 7:
//                        // Get Department by ID
//                        System.out.print("Enter department ID: ");
//                        int deptId = scanner.nextInt();
//                        Department dept = departmentDAO.getDepartment(deptId);
//                        if (dept != null) {
//                            System.out.println("ID: " + dept.getId());
//                            System.out.println("Name: " + dept.getName());
//                        } else {
//                            System.out.println("Department not found.");
//                        }
//                        break;

//                    case 8:
//                        // Get All Departments
//                        List<Department> departments = departmentDAO.getAllDepartments();
//                        for (Department d : departments) {
//                            System.out.println("ID: " + d.getId());
//                            System.out.println("Name: " + d.getName());
//                        }
//                        break;
//
//                    case 9:
//                        // Update Department
//                        System.out.print("Enter department ID to update: ");
//                        int updateDeptId = scanner.nextInt();
//                        scanner.nextLine();
//                        System.out.print("Enter new department name: ");
//                        String newDeptName = scanner.nextLine();
//                        Department updatedDept = new Department(updateDeptId, newDeptName);
//                        departmentDAO.updateDepartment(updatedDept);
//                        System.out.println("Department updated successfully.");
//                        break;
//
//                    case 10:
//                        // Delete Department
//                        System.out.print("Enter department ID to delete: ");
//                        int deleteDeptId = scanner.nextInt();
//                        departmentDAO.deleteDepartment(deleteDeptId);
//                        System.out.println("Department deleted successfully.");
//                        break;

                    case 6:
                        // Add Job
                        System.out.print("Enter job title: ");
                        String jobTitle = scanner.nextLine();
                        System.out.print("Enter minimum salary: ");
                        BigDecimal minSalary = scanner.nextBigDecimal();
                        System.out.print("Enter maximum salary: ");
                        BigDecimal maxSalary = scanner.nextBigDecimal();

                        Job job = new Job(0, jobTitle, minSalary, maxSalary);
                        jobDAO.addJob(job);
                        System.out.println("Job added successfully.");
                        break;

                    case 7:
                        // Get Job by ID
                        System.out.print("Enter job ID: ");
                        int job_Id = scanner.nextInt();
                        Job jobs = jobDAO.getJob(job_Id);
                        if (jobs != null) {
                            System.out.println("ID: " + jobs.getId());
                            System.out.println("Title: " + jobs.getTitle());
                            System.out.println("Min Salary: " + jobs.getMinSalary());
                            System.out.println("Max Salary: " + jobs.getMaxSalary());
                        } else {
                            System.out.println("Job not found.");
                        }
                        break;

                    case 8:
                        // Get All Jobs
                        List<Job> jobs1 = jobDAO.getAllJobs();
                        for (Job j : jobs1) {
                            System.out.println("ID: " + j.getId());
                            System.out.println("Title: " + j.getTitle());
                            System.out.println("Min Salary: " + j.getMinSalary());
                            System.out.println("Max Salary: " + j.getMaxSalary());
                        }
                        break;

//                    case 14:
//                        // Update Job
//                        System.out.print("Enter job ID to update: ");
//                        int updateJobId = scanner.nextInt();
//                        scanner.nextLine();
//                        System.out.print("Enter new job title: ");
//                        String newJobTitle = scanner.nextLine();
//                        System.out.print("Enter new minimum salary: ");
//                        BigDecimal newMinSalary = scanner.nextBigDecimal();
//                        System.out.print("Enter new maximum salary: ");
//                        BigDecimal newMaxSalary = scanner.nextBigDecimal();
//
//                        Job updatedJob = new Job(updateJobId, newJobTitle, newMinSalary, newMaxSalary);
//                        jobDAO.updateJob(updatedJob);
//                        System.out.println("Job updated successfully.");
//                        break;

                    case 9:
                        // Delete Job
                        System.out.print("Enter job ID to delete: ");
                        int deleteJobId = scanner.nextInt();
                        jobDAO.deleteJob(deleteJobId);
                        System.out.println("Job deleted successfully.");
                        break;

                    case 10:
                        // Add Salary
                        System.out.print("Enter employee ID: ");
                        int salaryEmpId = scanner.nextInt();
                        System.out.print("Enter salary amount: ");
                        BigDecimal amount = scanner.nextBigDecimal();
                        System.out.print("Enter effective date (yyyy-mm-dd): ");
                        scanner.nextLine();
                        String effectiveDateStr = scanner.nextLine();
                        Date effectiveDate = Date.valueOf(effectiveDateStr);

                        Salary salary = new Salary(0, salaryEmpId, amount, effectiveDate);
                        salaryDAO.addSalary(salary);
                        System.out.println("Salary added successfully.");
                        break;

                    case 11:
                        // Get Salary by ID
                        System.out.print("Enter salary ID: ");
                        int salaryId = scanner.nextInt();
                        Salary salaries = salaryDAO.getSalary(salaryId);
                        if (salaries != null) {
                            System.out.println("ID: " + salaries.getId());
                            System.out.println("Employee ID: " + salaries.getEmployeeId());
                            System.out.println("Amount: " + salaries.getAmount());
                            System.out.println("Effective Date: " + salaries.getEffectiveDate());
                        } else {
                            System.out.println("Salary not found.");
                        }
                        break;

                    case 12:
                        // Get All Salaries
                        List<Salary> Salary = salaryDAO.getAllSalaries();
                        for (Salary s : Salary) {
                            System.out.println("ID: " + s.getId());
                            System.out.println("Employee ID: " + s.getEmployeeId());
                            System.out.println("Amount: " + s.getAmount());
                            System.out.println("Effective Date: " + s.getEffectiveDate());
                        }
                        break;

//                    case 19:
//                        // Update Salary
//                        System.out.print("Enter salary ID to update: ");
//                        int updateSalaryId = scanner.nextInt();
//                        System.out.print("Enter new employee ID: ");
//                        int newSalaryEmpId = scanner.nextInt();
//                        System.out.print("Enter new salary amount: ");
//                        BigDecimal newAmount = scanner.nextBigDecimal();
//                        System.out.print("Enter new effective date (yyyy-mm-dd): ");
//                        scanner.nextLine();
//                        String newEffectiveDateStr = scanner.nextLine();
//                        Date newEffectiveDate = Date.valueOf(newEffectiveDateStr);
//
//                        Salary updatedSalary = new Salary(updateSalaryId, newSalaryEmpId, newAmount, newEffectiveDate);
//                        salaryDAO.updateSalary(updatedSalary);
//                        System.out.println("Salary updated successfully.");
//                        break;

                    case 13:
                        // Delete Salary
                        System.out.print("Enter salary ID to delete: ");
                        int deleteSalaryId = scanner.nextInt();
                        salaryDAO.deleteSalary(deleteSalaryId);
                        System.out.println("Salary deleted successfully.");
                        break;

                    case 14:
                        // Add Project
                        System.out.print("Enter project name: ");
                        String projectName = scanner.nextLine();
                        System.out.print("Enter start date (yyyy-mm-dd): ");
                        String startDateStr = scanner.nextLine();
                        Date startDate = Date.valueOf(startDateStr);
                        System.out.print("Enter end date (yyyy-mm-dd) (or press Enter for null): ");
                        String endDateStr = scanner.nextLine();
                        Date endDate = endDateStr.isEmpty() ? null : Date.valueOf(endDateStr);

                        Project project = new Project(0, projectName, startDate, endDate);
                        projectDAO.addProject(project);
                        System.out.println("Project added successfully.");
                        break;

                    case 15:
                        // Get Project by ID
                        System.out.print("Enter project ID: ");
                        int projectId = scanner.nextInt();
                        Project projects = projectDAO.getProject(projectId);
                        if (projects != null) {
                            System.out.println("ID: " + projects.getId());
                            System.out.println("Name: " + projects.getName());
                            System.out.println("Start Date: " + projects.getStartDate());
                            System.out.println("End Date: " + projects.getEndDate());
                        } else {
                            System.out.println("Project not found.");
                        }
                        break;

                    case 16:
                        // Get All Projects
                        List<Project> Project = projectDAO.getAllProjects();
                        for (Project p : Project) {
                            System.out.println("ID: " + p.getId());
                            System.out.println("Name: " + p.getName());
                            System.out.println("Start Date: " + p.getStartDate());
                            System.out.println("End Date: " + p.getEndDate());
                        }
                        break;

//                    case 24:
//                        // Update Project
//                        System.out.print("Enter project ID to update: ");
//                        int updateProjectId = scanner.nextInt();
//                        scanner.nextLine();
//                        System.out.print("Enter new project name: ");
//                        String newProjectName = scanner.nextLine();
//                        System.out.print("Enter new start date (yyyy-mm-dd): ");
//                        String newStartDateStr = scanner.nextLine();
//                        Date newStartDate = Date.valueOf(newStartDateStr);
//                        System.out.print("Enter new end date (yyyy-mm-dd) (or press Enter for null): ");
//                        String newEndDateStr = scanner.nextLine();
//                        Date newEndDate = newEndDateStr.isEmpty() ? null : Date.valueOf(newEndDateStr);
//
//                        Project updatedProject = new Project(updateProjectId, newProjectName, newStartDate, newEndDate);
//                        projectDAO.updateProject(updatedProject);
//                        System.out.println("Project updated successfully.");
//                        break;

                    case 17:
                        // Delete Project
                        System.out.print("Enter project ID to delete: ");
                        int deleteProjectId = scanner.nextInt();
                        projectDAO.deleteProject(deleteProjectId);
                        System.out.println("Project deleted successfully.");
                        break;

                    case 18:
                        // Add Employee to Project
                        System.out.print("Enter employee ID: ");
                        int empIdToAdd = scanner.nextInt();
                        System.out.print("Enter project ID: ");
                        int projIdToAdd = scanner.nextInt();
                        employeeProjectDAO.addEmployeeProject(empIdToAdd, projIdToAdd);
                        System.out.println("Employee added to project successfully.");
                        break;

//                    case 27:
//                        // Get Projects by Employee ID
//                        System.out.print("Enter employee ID: ");
//                        int empIdToGetProjects = scanner.nextInt();
//                        List<Integer> projectIds = employeeProjectDAO.getProjectsByEmployee(empIdToGetProjects);
//                        for (int pId : projectIds) {
//                            System.out.println("Project ID: " + pId);
//                        }
//                        break;

//                    case 28:
//                        // Get Employees by Project ID
//                        System.out.print("Enter project ID: ");
//                        int projIdToGetEmployees = scanner.nextInt();
//                        List<Integer> employeeIds = employeeProjectDAO.getEmployeesByProject(projIdToGetEmployees);
//                        for (int eId : employeeIds) {
//                            System.out.println("Employee ID: " + eId);
//                        }
//                        break;
//
//                    case 29:
//                        // Delete Employee from Project
//                        System.out.print("Enter employee ID: ");
//                        int empIdToDelete = scanner.nextInt();
//                        System.out.print("Enter project ID: ");
//                        int projIdToDelete = scanner.nextInt();
//                        employeeProjectDAO.deleteEmployeeProject(empIdToDelete, projIdToDelete);
//                        System.out.println("Employee removed from project successfully.");
//                        break;

                    case 19:
                        // Exit
                        scanner.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}