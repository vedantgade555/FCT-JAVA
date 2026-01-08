package SetInterface;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        HashSet<String> hs1 = new HashSet<String>();
        hs1.add("Monday");
        hs1.add("Tuesday");
        hs1.add("Wednesday");
        hs1.add("Thursday");
        hs1.add("Friday");
        hs1.add("Saturday");
        hs1.add("Sunday");
        hs1.add(null);

        System.out.println("HashSet "+hs1);

        LinkedHashSet<String> hs2 = new LinkedHashSet<>();
        hs2.add("Monday");
        hs2.add("Tuesday");
        hs2.add("Wednesday");
        hs2.add("Thursday");
        hs2.add("Friday");
        hs2.add("Saturday");
        hs2.add("Sunday");
        hs2.add(null);
        System.out.println("Linked HashSet "+hs2);


        TreeSet<String> hs3 = new TreeSet<>();
        hs3.add("Monday");
        hs3.add("Tuesday");
        hs3.add("Wednesday");
        hs3.add("Thursday");
        hs3.add("Friday");
        hs3.add("Saturday");
        hs3.add("Sunday");
       // hs3.add(null);// it does not allow null value

        System.out.println("TreeSet "+hs3);

    }
}
