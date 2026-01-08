package OOP.Polymorphism.FinalKeyword;

public class FinalMethodDemo {
    class A{
//        We cannot override this method using child class but they can call
        final void run()
        {
            System.out.println("Run method of class A");
        }
    }
    class B extends A{

    }
}
