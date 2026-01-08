package OOP.Inheritance.EmpDetails;

public class Address {
    String city,state,country;

    public Address(String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }
}

class Employee{
    int empid;
    String ename;
    Address eadress;

    public Employee(int empid, String ename, Address eadress) {
        this.empid = empid;
        this.ename = ename;
        this.eadress = eadress;
    }

    void display()
    {
        System.out.println(empid+" "+ename);
        System.out.println(eadress.city+" "+eadress.state+" "+eadress.country);
    }
}

class TestAgree
{
    public static void main(String[] args) {
        Address a1 = new Address("Pune","Maharashtra","India");
        Employee e1 = new Employee(101,"Keshav",a1);
        e1.display();
    }
}
