package OOP.Polymorphism;

class OverloadDemo {
//    By changing no of argument
    void show()
    {
        System.out.println("Welcome to Overloading");
    }

    void show(String name)
    {
        System.out.println(name+" Welcome to Overloading");
    }

    public static void main(String[] args) {
        OverloadDemo d1 = new OverloadDemo();
        d1.show();
        d1.show("Rahul");
    }
}
