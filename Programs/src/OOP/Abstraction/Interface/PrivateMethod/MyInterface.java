package OOP.Abstraction.Interface.PrivateMethod;

interface MyInterface {
    default void show()
    {
        System.out.println("Use to show Messages");
    }

    default void display()
    {
        printDetails();
        System.out.println("Use to display data");
    }

    private void printDetails()
    {
        System.out.println("Used to print Details");
    }
}

class privateInterface implements MyInterface
{

}

class TestPrivateInterface
{
    public static void main(String[] args) {
        privateInterface p1 = new privateInterface();
        p1.show();
        p1.display();
//        It will not accessiable outside the interface
//        p1.printDetaild();

    }
}