package OOP.Polymorphism.SuperKeyword;

class Parent
{
    String message = "Happy Diwali";

    void eat()
    {
        System.out.println("My eating Diwali Sweets");
    }
}

public class SuperDemo extends Parent{
    String message = "Every One";

    void eat()
    {
        super.eat();
        System.out.println("I like home made Diwali Sweets");
    }
    void showMessage()
    {
        // Accessing parent class variable
        System.out.println(super.message);
        System.out.println(message);
        // Accessing paernt class method
//        super.eat();
    }
    public static void main(String[] args) {
        SuperDemo d1 = new SuperDemo();
        d1.showMessage();
        d1.eat();
    }
}
