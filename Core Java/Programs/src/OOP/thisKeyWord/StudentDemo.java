package OOP.thisKeyWord;
//Use the conceot of constructor chaining
public class StudentDemo {
    int rollno;
    String name,course;
    float fee;

    StudentDemo( int rollno,String name,String course)
    {
        this.rollno = rollno;
        this.name = name;
        this.course = course;
        this.fee = fee;
    }
    StudentDemo(int rollno,String name,String course,float fee)
    {
        this(rollno,name,course); // reusing constructor or constructor chaining
        this.fee = fee;
    }
    void display() {
        System.out.println("StudentDemo{" +
                "rollno=" + rollno +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", fee=" + fee +
                '}');
    }

    public static void main(String[] args) {
        StudentDemo s1 = new StudentDemo(101,"Jay","BCS",50000);
        StudentDemo s2 = new StudentDemo(102,"Vijay","BCA",56000);

        s1.display();
        s2.display();
    }
}
