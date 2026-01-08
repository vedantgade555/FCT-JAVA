package OOP.Object_4;

class Dog {
    String name ="Max";

    void bark()
    {
        System.out.println("Dogs Bark");
    }

    public static void main(String[] args) {
        Dog d1 = new Dog();
        d1.bark();
        System.out.println(d1.name);
    }
}
