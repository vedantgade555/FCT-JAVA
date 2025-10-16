package OOP.Inheritance;
// We are achieving Mulitple Inheritance

interface Ai
{
    int id=101;
}

interface Bi
{
    String name = "Vedant";
}

interface D
{
    String color = "White";
}
class InterfaceMultiple implements Ai,Bi,D{

    public static void main(String[] args) {
        System.out.println(id);
        System.out.println(name);
        System.out.println(color);
    }
}



class InterfaceHybrid implements Ai,Bi{
    public static void main(String[] args) {
        System.out.println(id);
        System.out.println(name);
//        System.out.println(color);
    }
}
