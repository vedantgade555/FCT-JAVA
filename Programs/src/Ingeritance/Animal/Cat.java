package Ingeritance.Animal;

public class Cat extends Animal {
    Cat(String name)
    {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println("Making Sound meow");
    }

    public static void main(String[] args) {
        Cat c1 = new Cat("Cat");
        c1.eat();
        c1.makeSound();

    }
}
