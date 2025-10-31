package OOP.Encapsulation.AcessSpecifier.package2;

import OOP.Encapsulation.AcessSpecifier.package1.ProtectedDemo;

public class ProtectedTest extends ProtectedDemo{
    public static void main(String[] args) {
        ProtectedDemo d1 = new ProtectedDemo();
        System.out.println(d1.no);
        d1.printDetails();
    }
}
