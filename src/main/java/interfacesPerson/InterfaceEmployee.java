package interfacesPerson;

import java.util.List;

public interface InterfaceEmployee extends InterfacePerson {
    int getEmpId();

    double getSalary();
    void setSalary(double salary);

    List<String> getEducations();
    void setEducations(List<String> education);
}
