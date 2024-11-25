package hrmanagement;

import java.util.ArrayList;
import java.util.Scanner;

public class HRManagementApp {
    private static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("=== Human Resource Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    viewAllEmployees();
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    // Method to add an employee
private static void addEmployee(Scanner scanner) {
    System.out.print("Enter employee name: ");
    String name = scanner.next();

    System.out.print("Enter employee age: ");
    int age = scanner.nextInt();

    System.out.print("Enter employee position: ");
    String position = scanner.next(); // posisi harus string

    System.out.print("Enter employee salary: ");
    while (!scanner.hasNextDouble()) {
        System.out.println("Invalid input. Please enter a numeric value for salary.");
        scanner.next(); // membersihkan input yang salah
    }
    double salary = scanner.nextDouble();

    Employee newEmployee = new Employee(name, age, position, salary);
    employees.add(newEmployee);

    System.out.println("Employee added successfully.");
}


    // Method to view all employees
    private static void viewAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            System.out.println("=== Employee List ===");
            for (Employee emp : employees) {
                emp.displayEmployeeDetails();
                System.out.println("-----------------------");
            }
        }
    }
}
