package OOP.thisKeyWord;

class ConMethod {
    void display(int a)
    {
        System.out.println("Hello from display"+a);
    }
    void show(int a )
    {
        System.out.println("Hello from show"+a);
        this.display(a);
    }
}

class Test
{
    public static void main(String[] args) {
        ConMethod m1 = new ConMethod();
        m1.show(10);

    }
}
