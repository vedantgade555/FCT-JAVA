package OOP.Inheritance.EmpDetails;

class Emp{
    int salary = 40000;
    String company_name ="FCTP";
}

class Programmer extends Emp{
    int bonus = 10000;
    String name  = "Shyam";
    String skills = "java";
}

class Jprogrammer extends Programmer
{
    int bonus=5000;
    String name="Rajesh";
}

public class TestInheritance {
    public static void main(String[] args) {
//        Programmer p = new Programmer();
        Jprogrammer p = new Jprogrammer();
        System.out.println("Name: "+p.name+"Salary: "+p.salary+"Bonus: "+p.bonus+"Company Name "+p.company_name+"Skills "+p.skills);
    }
}
