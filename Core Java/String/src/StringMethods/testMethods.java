package StringMethods;

public class testMethods {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = " World";

        System.out.println(s1.concat(s2));
        String s3  = s1+s2;
        System.out.println(s3);
        System.out.println("Length is "+s3.length());
        System.out.println("Char At "+s3.charAt(3));

        System.out.println("Substring "+ s3.substring(5,11));
        System.out.println("Substring "+ s3.substring(5));

        System.out.println(s1.equals(s2));
        String s4 = new String("Hello");
        System.out.println(s1.equals(s4));

        System.out.println(s3.toUpperCase());
        System.out.println(s3.toLowerCase());

        String S1;
        S1 = String.join("<","We","are","received","huge","rain","in","Maharashtra");
        System.out.println(S1);

        System.out.println(s3.contains("Hello"));

        String S2 = "             coding is        ";
        System.out.println(S2.trim()+"awsoom");

        System.out.println(s3.replace('o','l'));

    }
}
