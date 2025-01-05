package Person;
import interfacesPerson.InterfacePerson;

public class Person implements InterfacePerson {
    private String name;
    private int age;
    private String gender;
    private String phoneNo;
    private String email;

    public Person() {
        //this.id = generateId(); // ID unic generat
        this.name = "Unknown";
        this.age = 0;           // 0 indică vârsta necunoscută
        this.gender = "Unknown";
        this.phoneNo = "Unknown";
        this.email = "Unknown";
    }

    public Person(String name, int age, String gender, String phoneNo, String email) {
        //this.id = generateId();
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String getPhoneNo() {
        return phoneNo;
    }

    @Override
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
