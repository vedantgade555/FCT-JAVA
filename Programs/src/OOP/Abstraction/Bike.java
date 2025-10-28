package OOP.Abstraction;

abstract class Bike {
    abstract void run();
    void display(){
        System.out.println("Non-Abstract Method");
    }
}
class Bajaj extends Bike{
    void run()
    {
        System.out.println("Bike is running");
    }
}
class Test{
    public static void main(String[] args) {
        Bajaj b1 = new Bajaj();
        b1.run();
        b1.display();
    }
}
