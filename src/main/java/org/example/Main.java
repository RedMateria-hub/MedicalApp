package org.example;

import Person.Employee;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int choice = 0;
        Employee employee = null;
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("1.Create employee from input.\n2.Read Employee from file\n" +
                    "3.Write current employee into file.\n4.Print out info about the employee.");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    employee = EmpFileManager.createEmployeeFromInput();
                    break;
                case 2:
                    employee = EmpFileManager.readEmployeeFromFile("src/main/java/readJson.json");
                    break;
                case 3:
                    EmpFileManager.writeEmployeeToFile(employee, "src/main/java/writtenJson.json");
                    break;
                case 4:
                    if (employee == null){
                        System.out.println("No employee found.");
                    }
                    else
                        System.out.println(employee);
                    break;
            }
        } while (choice != 5);
    }
}