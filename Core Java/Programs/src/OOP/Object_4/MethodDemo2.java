package OOP.Object_4;

public class MethodDemo2 {
    public void display()
    {
        System.out.println("This is userdefine normal method");
    }

    static void getOut()
    {
        System.out.println("Userdefine Static Method");
    }
    public static void main(String[] args) {
        MethodDemo2 m1 = new MethodDemo2();
        m1.display();
        getOut();
    }
}
