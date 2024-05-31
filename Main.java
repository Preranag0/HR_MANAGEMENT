
import DAO.*;
import Models.Department;
import Models.Employee;
import Service.EmployeeServices;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        DepartmentDAO departmentDAO = new DepartmentDAO();
        JobDAO jobDAO = new JobDAO();
        SalaryDAO salaryDAO = new SalaryDAO();
        ProjectDAO projectDAO = new ProjectDAO();
        EmployeeProjectDAO employeeProjectDAO = new EmployeeProjectDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("HR Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee");
            System.out.println("3. View All Employees");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter department ID: ");
                    int departmentId = scanner.nextInt();
                    System.out.print("Enter job ID: ");
                    int jobId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter hire date (YYYY-MM-DD): ");
                    Date hireDate = Date.valueOf(scanner.nextLine());

                    Employee employee = new Employee(0, name, departmentId, jobId, email, hireDate);
                    try {
                        employeeDAO.addEmployee(employee);
                        System.out.println("Employee added successfully.");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.print("Enter employee ID: ");
                    int id = scanner.nextInt();
                    try {
                        Employee emp = employeeDAO.getEmployee(id);
                        if (emp != null) {
                            System.out.println("Employee Details: " + emp);
                        } else {
                            System.out.println("Employee not found.");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        List<Employee> employees = employeeDAO.getAllEmployees();
                        for (Employee emp : employees) {
                            System.out.println(emp);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    System.out.print("Enter employee ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new department ID: ");
                    int newDepartmentId = scanner.nextInt();
                    System.out.print("Enter new job ID: ");
                    int newJobId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter new email: ");
                    String newEmail = scanner.nextLine();
                    System.out.print("Enter new hire date (YYYY-MM-DD): ");
                    Date newHireDate = Date.valueOf(scanner.nextLine());

                    Employee updatedEmployee = new Employee(updateId, newName, newDepartmentId, newJobId, newEmail, newHireDate);
                    try {
                        employeeDAO.updateEmployee(updatedEmployee);
                        System.out.println("Employee updated successfully.");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    System.out.print("Enter employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    try {
                        employeeDAO.deleteEmployee(deleteId);
                        System.out.println("Employee deleted successfully.");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}