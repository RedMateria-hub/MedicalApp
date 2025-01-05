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

        // Getting general information
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

        // Getting education details
        List<String> educations = new ArrayList<>();
        System.out.println("Enter education details (type 'x' when finished): ");
        while (true) {
            String education = scanner.nextLine();
            if (education.equalsIgnoreCase("x")) {
                break;
            }
            educations.add(education);
        }

        // Create the Employee object with gathered data
        Employee employee = new Employee(name, age, gender, phoneNo, email, educations);

        // Return the created Employee object
        return employee;
    }
}
