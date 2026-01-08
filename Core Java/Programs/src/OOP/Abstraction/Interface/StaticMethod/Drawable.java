package OOP.Abstraction.Interface.StaticMethod;

interface Drawable {
    void draw();
    static int cube(int x)
    {
        return x*x*x;
    }

    default void display()
    {
        System.out.println("Default Method");
    }
}

class rectangle implements Drawable
{
//    Compulsary to add public
    public void draw()
    {
        System.out.println("Drawing Rectangle");
    }


}

class TestStaticInterface
{
    public static void main(String[] args) {
        Drawable d1 = new rectangle();
        d1.draw();
        System.out.println(Drawable.cube(5));
        d1.display();
    }
}
