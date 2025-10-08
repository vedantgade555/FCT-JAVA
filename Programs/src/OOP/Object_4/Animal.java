package OOP.Object_4;

public class Animal {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void display(String a)
    {
        name = a;
    }

    public static void main(String[] args) {
        Animal a1 = new Animal();
        a1.setName("Lion");
        a1.getName();
        System.out.println(a1.getName());
    }
}
