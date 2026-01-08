package OOP.Constructor;

public class Student {
    int id;
    String name;
    double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public void display()
     {
         System.out.println("ID: "+id+" Name: "+name+" Marks: "+marks);
     }

    public static void main(String[] args) {
        Student d1 = new Student(101,"Rakesh",55.55);
        d1.display();
    }
}                           
