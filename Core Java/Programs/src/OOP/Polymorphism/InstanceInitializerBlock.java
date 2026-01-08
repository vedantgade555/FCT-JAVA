package OOP.Polymorphism;

class Truck
{
    int speed;

    public Truck()
    {
        System.out.println("Speed of the truck is "+speed);
    }

//    This will used they will share same value for all objects
//    This will execuded first
    {
        speed=50;
        System.out.println("Instance Initializer Block Executed");
    }



    public static void main(String[] args) {
        Truck t1 = new Truck();
        Truck t2 = new Truck();
    }
}

