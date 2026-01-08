package OOP.Polymorphism;

class Vehicle
{
    public void run()
    {
        System.out.println("Hello from Parent Class method");
    }
}

class Bike extends Vehicle
{
//    public void run()
//    {
////        System.out.println("Hello from Child Class method");
//    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle();
//        v1.run();

        Bike b1 = new Bike();
        b1.run();
    }
}
