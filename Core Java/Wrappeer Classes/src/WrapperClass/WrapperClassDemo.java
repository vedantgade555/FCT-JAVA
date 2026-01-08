package WrapperClass;

public class WrapperClassDemo {
    public static void main(String[] args) {
        int i=20;
        int a=30;
        Integer itr = Integer.valueOf(i); // explicit conversion --> autoboxing

        Integer j = a; // autoboxing


        System.out.println(i+" "+a);

        System.out.println(itr+" "+j);

        char c='c';

        Character c1 = Character.valueOf(c);

        // unboxing

        Integer s  = new Integer(10);
        int x = s.intValue();
        int y=s;
        System.out.println(x+" "+y);

    }
}
