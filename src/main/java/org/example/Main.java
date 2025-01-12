package org.example;

import Person.Employee;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Employee> employees = EmpFileManager.loadEmployeesFromJson("src/main/java/employees.json");

        int choice = 0;
        double newSalary = 0;
        Employee employee = null;
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("1.Create employee from input.\n2.Read Employee from file\n" +
                    "3.Write current employee into file.\n4.Print out info about the employee." +
                    "\n5.Input salary for employee.\n6.Add current employee to the list." +
                    "\n7.Print current list of employees.\n8.Sort current list by name.\n9.Save current list " +
                    "to a json file.\n10.Exit.");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    employee = EmpFileManager.createEmployeeFromInput();
                    break;
                case 2:
                    employee = EmpFileManager.readEmployeeFromFile("src/main/java/readJson.json");
                    break;
                case 3:
                    if (employee == null){
                        System.out.println("No employee found.");
                        break;
                    }
                    EmpFileManager.writeEmployeeToFile(employee, "src/main/java/writtenJson.json");
                    break;
                case 4:
                    if (employee == null){
                        System.out.println("No employee found.");
                    }
                    else
                        System.out.println(employee);
                    break;
                case 5:
                    if (employee == null){
                        System.out.println("No employee found.");
                        break;
                    }
                    System.out.println("Input salary of the employee.");
                    newSalary = scanner.nextDouble();
                    employee.setSalary(newSalary);
                    break;
                case 6:
                    if (employee == null){
                        System.out.println("No employee found.");
                        break;
                    }
                    employees.add(employee);
                    break;
                case 7:
                    for (Employee emp : employees){
                        System.out.println(emp);
                    }
                    break;
                case 8:
                    employees.sort(Comparator.comparing(Employee::getName));
                    break;
                case 9:
                    EmpFileManager.saveEmployeesFromJson(employees, "src/main/java/employees.json");
                    break;
                case 10:
                    System.out.println("Bye.\n");
                    break;
                default:
                    System.out.println("Invalid choice.\n");
                    break;
            }
        } while (choice != 10);
    }
}