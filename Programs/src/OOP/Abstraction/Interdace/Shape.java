package OOP.Abstraction.Interdace;

interface Shape {
    void draw();
    void display();
//    Default method
    default void run(){
        System.out.println("Drawing Shape");
    }
}

class circle implements Shape{
    public void draw()
    {
        System.out.println("Drawing Circle");
    }

    public void display()
    {
        System.out.println("Show Circle");
    }
}


class testInterface
{
    public static void main(String[] args) {
        Shape s = new circle();
        s.draw();
        s.display();
    }
}
