package org.example;
import Person.Employee;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class EmployeeTest {

    private Employee employee;

    @BeforeEach
    public void setUp() {
        // Initialize an employee object to test the methods
        List<String> educations = Arrays.asList("Computer Science", "Software Engineering");
        employee = new Employee("John Doe", 30, "Male", "123-456-7890", "johndoe@example.com", 50000.0, educations);
    }

    @Test
    public void testEmployeeConstructorWithAllAttributes() {
        List<String> educations = Arrays.asList("Business Administration");
        Employee newEmployee = new Employee("Jane Smith", 25, "Female", "987-654-3210", "janesmith@example.com", 55000.0, educations);

        assertEquals("Jane Smith", newEmployee.getName());
        assertEquals(25, newEmployee.getAge());
        assertEquals("Female", newEmployee.getGender());
        assertEquals("987-654-3210", newEmployee.getPhoneNo());
        assertEquals("janesmith@example.com", newEmployee.getEmail());
        assertEquals(55000.0, newEmployee.getSalary(), "Salary should be set correctly");
        assertEquals(educations, newEmployee.getEducations(), "Educations should be set correctly");
    }

    @Test
    public void testEmployeeConstructorWithoutSalary() {
        List<String> educations = Arrays.asList("Computer Science");
        Employee newEmployee = new Employee("Mark Spencer", 28, "Male", "456-789-0123", "markspencer@example.com", educations);

        assertEquals("Mark Spencer", newEmployee.getName());
        assertEquals(28, newEmployee.getAge());
        assertEquals("Male", newEmployee.getGender());
        assertEquals("456-789-0123", newEmployee.getPhoneNo());
        assertEquals("markspencer@example.com", newEmployee.getEmail());
        assertEquals(0.0, newEmployee.getSalary(), "Default salary should be 0.0");
        assertEquals(educations, newEmployee.getEducations(), "Educations should be set correctly");
    }

    @Test
    public void testGetEmpId() {
        assertTrue(employee.getEmpId() > 0, "Employee ID should be a positive number");
    }

    @Test
    public void testSetSalary() {
        employee.setSalary(60000.0);
        assertEquals(60000.0, employee.getSalary(), "Salary should be updated to 60000.0");
    }

    @Test
    public void testSetEducations() {
        List<String> newEducations = Arrays.asList("PhD in Computer Science");
        employee.setEducations(newEducations);
        assertEquals(newEducations, employee.getEducations(), "Educations should be updated correctly");
    }

    @Test
    public void testEmployeeIdUniqueness() {
        Employee employee2 = new Employee("Andreea", 35, "Female", "111-222-3333", "alicebrown@example.com", 55000.0, Arrays.asList("Bachelor's in Mathematics"));
        assertNotEquals(employee.getEmpId(), employee2.getEmpId(), "Employee IDs should be unique");
    }

    @Test
    public void testDefaultConstructor() {
        Employee newEmployee = new Employee();
        assertEquals("Unknown", newEmployee.getName(), "Default name should be 'Unknown'");
        assertEquals(0, newEmployee.getAge(), "Default age should be 0");
        assertEquals("Unknown", newEmployee.getGender(), "Default gender should be 'Unknown'");
        assertEquals("Unknown", newEmployee.getPhoneNo(), "Default phoneNo should be 'Unknown'");
        assertEquals("Unknown", newEmployee.getEmail(), "Default email should be 'Unknown'");
        assertEquals(0.0, newEmployee.getSalary(), "Default salary should be 0.0");
    }

    @Test
    public void testSetName() {
        employee.setName("Mihai");
        assertEquals("Mihai", employee.getName(), "Name should be updated correctly");
    }

    @Test
    public void testSetAge() {
        employee.setAge(35);
        assertEquals(35, employee.getAge(), "Age should be updated correctly");
    }

    @Test
    public void testSetGender() {
        employee.setGender("Male");
        assertEquals("Male", employee.getGender(), "Gender should be updated correctly");
    }

    @Test
    public void testSetPhoneNo() {
        employee.setPhoneNo("555-000-1234");
        assertEquals("555-000-1234", employee.getPhoneNo(), "Phone number should be updated correctly");
    }

    @Test
    public void testSetEmail() {
        employee.setEmail("michael.johnson@example.com");
        assertEquals("michael.johnson@example.com", employee.getEmail(), "Email should be updated correctly");
    }

    @Test
    public void testSalaryUpdate() {
        employee.setSalary(70000.0);
        assertEquals(70000.0, employee.getSalary(), "Salary should be updated correctly");
    }

    @Test
    public void testGetEducations() {
        List<String> educations = employee.getEducations();
        assertEquals(Arrays.asList("Computer Science", "Software Engineering"), educations, "Educations should be fetched correctly");
    }
}
