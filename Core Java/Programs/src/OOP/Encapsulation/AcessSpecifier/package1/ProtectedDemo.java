package OOP.Encapsulation.AcessSpecifier.package1;

public class ProtectedDemo {
    public int no=10;

    public void printDetails()
    {
        System.out.println("Printing details from protected method");
    }

    public static void main(String[] args) {
        ProtectedDemo d1 = new ProtectedDemo();
        System.out.println(d1.no);
        d1.printDetails();
    }
}
