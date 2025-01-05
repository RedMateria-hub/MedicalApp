package Person;
import interfacesPerson.InterfaceEmployee;

import java.util.ArrayList;
import java.util.List;

public class Employee extends Person implements InterfaceEmployee {
    private static int statEmpId = 1;
    private final int empId;
    private double salary;
    private List<String> educations;

    public Employee() {
        super();
        this.empId = generateEmpId();
        this.salary = 0.0;
        this.educations = new ArrayList<String>();
    }

    public Employee(String name, int age, String gender, String phoneNo, String email, List<String> educations) {
        super(name, age, gender, phoneNo, email);
        this.empId = generateEmpId();
        this.salary = 0.0;
        this.educations = educations;
    }

    public Employee(String name, int age, String gender, String phoneNo, String email, double salary, List<String> educations) {
        super(name, age, gender, phoneNo, email);
        this.empId = generateEmpId();
        this.salary = salary;
        this.educations = educations;
    }

    private static synchronized int generateEmpId() {
        return statEmpId++;
    }

    @Override
    public int getEmpId() {
        return empId;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public List<String> getEducations(){
        return educations;
    }

    @Override
    public void setEducations(List<String> educations){
        this.educations = educations;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", salary=" + salary +
                ", educations=" + educations +
                ", " + super.toString() +
                '}';
    }

}
