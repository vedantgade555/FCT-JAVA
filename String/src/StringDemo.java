public class StringDemo {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s3 = "Hello";
        String s2 = new String("Welcome");
        String s4 = new String("Welcome");

        System.out.println(s1+" "+s2+" "+s3+" "+s4);
        s3 = "HelloTest";
        s4 = "WelcomeTest";

        System.out.println(s1+" "+s2+" "+s3+" "+s4);

        String S1 = "Hello";
        System.out.println(S1+" ".concat(("Vedant")));
        System.out.println(S1);

    }
}
