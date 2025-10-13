package OOP.thisKeyWord;

public class VerifyThis {
    void info()
    {
        System.out.println(this); // reference number
    }

    public static void main(String[] args) {
        VerifyThis t1 = new VerifyThis();
        System.out.println(t1);// reference number
        t1.info();
    }
}
