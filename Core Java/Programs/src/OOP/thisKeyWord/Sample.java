package OOP.thisKeyWord;
// We are passing this as a parameter using this keyword
public class Sample {
    int id;
    String name;
    Sample(int id,String name)
    {
        this.id = id;
        this.name = name;
    }
    void display(Sample obj)
    {
        System.out.println("Display Method Execute");
        System.out.println("Id :"+id+"Name : "+name);
    }

    void show()
    {
        System.out.println("Show method Executed");
        display(this);
    }

    void info()
    {
        System.out.println("Info method Executed");
    }

    public static void main(String[] args) {
        Sample s1 = new Sample(101,"Raj");
        s1.show();

        Sample s2 = new Sample(102,"Ram");
        s2.show();
    }
}
