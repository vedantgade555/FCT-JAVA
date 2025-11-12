package Mutability;

public class TestMutable {
    public static void main(String[] args) {
        String s1 = new String("Hello");
        s1.concat("Krish");
        System.out.println(s1);

//        StringBuffer sb = new StringBuffer("Hello");
        StringBuffer sb = new StringBuffer();
        System.out.println(sb.capacity()); //(previouscapaciy+1)*2
        sb.append("Welcome everyone ");
        System.out.println(sb);
        System.out.println(sb.capacity());

        StringBuffer sb1 = new StringBuffer("Welcome to hood");
        System.out.println(sb1.capacity());
        System.out.println("Length: "+sb1.length());
        System.out.println("Reverse String; "+sb1.reverse());
        System.out.println("Character at specific index: "+sb1.charAt(5));
        sb1.setCharAt(2,'r');
        System.out.println("Add character at specific index: "+ sb1);
        System.out.println(sb1.isEmpty());
        System.out.println(sb1.hashCode());
        System.out.println(sb.substring(2));
        System.out.println("String Class"+sb1.getClass());



//String Builder


        StringBuilder sb2 = new StringBuilder("Welcome to hood");
        System.out.println(sb2.capacity());
        System.out.println("Length: "+sb2.length());
        System.out.println("Reverse String; "+sb2.reverse());
        System.out.println("Character at specific index: "+sb2.charAt(5));
        sb1.setCharAt(2,'r');
        System.out.println("Add character at specific index: "+ sb2);
        System.out.println(sb2.isEmpty());
        System.out.println(sb2.hashCode());
        System.out.println(sb2.substring(2));
        System.out.println("String Class"+sb2.getClass());


    }
}
