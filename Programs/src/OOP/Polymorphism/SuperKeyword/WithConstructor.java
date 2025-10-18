package OOP.Polymorphism.SuperKeyword;

class Vehical
{
    int chesisno;
    String vehicalType;

    public Vehical(int chesisno, String vehicalType) {
        this.chesisno = chesisno;
        this.vehicalType = vehicalType;
    }
}
class Bike extends Vehical
{
    String color;

    public Bike(int chesisno, String vehicalType,String color)
    {
        super(chesisno,vehicalType);
        this.color = color;

    }

    void show()
    {
        System.out.println(super.chesisno+" "+super.vehicalType+" "+color);
    }
}

public class WithConstructor {
    public static void main(String[] args) {
        Bike b1 = new Bike(101,"Heavy","red");
        b1.show();
    }
}
