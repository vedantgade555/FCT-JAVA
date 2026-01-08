package OOP.Inheritance.Animal;

public class Animal {
    String name;
    Animal(String name)
    {
        this.name=name;
    }

    void eat()
    {
        System.out.println(name+ " is eating ");
    }

    void makeSound()
    {
        System.out.println(name+ " is making sound ");
    }
}
