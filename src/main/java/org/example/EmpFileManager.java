package org.example;
import Person.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpFileManager {
    public static void writeEmployeeToFile(Employee employee, String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        try {
            objectMapper.writeValue(new File(filePath), employee);
            System.out.println("Employee was succesfully written to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Employee readEmployeeFromFile(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        try {
            return objectMapper.readValue(new File(filePath), Employee.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Employee createEmployeeFromInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter gender: ");
        String gender = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNo = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        List<String> educations = new ArrayList<>();
        System.out.println("Enter education details (type 'x' when finished): ");
        while (true) {
            String education = scanner.nextLine();
            if (education.equalsIgnoreCase("x")) {
                break;
            }
            educations.add(education);
        }

        Employee employee = new Employee(name, age, gender, phoneNo, email, educations);

        return employee;
    }

    public static List<Employee> loadEmployeesFromJson(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        List<Employee> employees = objectMapper.readValue(new File(filePath), objectMapper.getTypeFactory().constructCollectionType(List.class, Employee.class));

        return employees;
    }

    public static void saveEmployeesFromJson(List<Employee> employees, String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        try {
            objectMapper.writeValue(new File(filePath), employees);
            System.out.println("Employees were succesfully written to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
