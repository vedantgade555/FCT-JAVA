package OOP.thisKeyWord;

class A
{
    A getA()
    {
        return this;
    }
    void message()
    {
        System.out.println("Hello Everyone");
    }
}



class TestA {
    public static void main(String[] args) {
        new A().getA().message();
    }
}
