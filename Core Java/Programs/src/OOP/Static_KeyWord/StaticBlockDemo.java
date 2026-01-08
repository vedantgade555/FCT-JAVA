package OOP.Static_KeyWord;

public class StaticBlockDemo {

    int a;
    static int b;

    StaticBlockDemo()
    {

    }

    static {
        b=10;
        System.out.println("Static Block Execute");
    }
//    Static block will exected alwys first before first

    void show()
    {
        System.out.println("a: "+a+"b: "+b);
    }
    public static void main(String[] args) {
        System.out.println("Main Block Executed");
        StaticBlockDemo s1 = new StaticBlockDemo();
        s1.show();

    }
}
