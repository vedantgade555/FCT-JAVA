package OOP.Polymorphism.FinalKeyword;

public class FinalVariableDemo {
    final int no = 50;
    void display()
    {
//        no=100;
        System.out.println("Value of no: "+no);
    }

    public static void main(String[] args) {
        FinalVariableDemo d1 = new FinalVariableDemo();
        d1.display();
    }
}
