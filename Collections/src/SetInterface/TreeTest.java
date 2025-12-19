package SetInterface;

import java.util.TreeSet;

public class TreeTest {
    public static void main(String[] args) {
        TreeSet<Integer> t1 = new TreeSet<>();
        t1.add(27);
        t1.add(26);
        t1.add(21);
        t1.add(16);
        t1.add(19);
        t1.add(18);
        t1.add(17);

        System.out.println(t1);
        t1.pollFirst();
        t1.pollLast();
        System.out.println("After Poll "+t1);
        System.out.println("Descending "+t1.descendingSet());
        System.out.println("HeadSet "+t1.headSet(19,true));
        System.out.println("HeadSet "+t1.headSet(19,false));
        System.out.println("TailSet "+t1.tailSet(19,true));
        System.out.println("TailSet "+t1.tailSet(19,false));
        System.out.println("Subset "+t1.subSet(18,true,26,true));
        System.out.println("Subset "+t1.subSet(18,true,26,false));
        System.out.println("Subset "+t1.subSet(18,false,26,true));
        System.out.println("Higher "+t1.higher(19));
        System.out.println("Lower "+t1.lower(19));

        System.out.println("Round of 14.28 is "+Math.round(14.28));
        System.out.println("Round of 14.58 is "+Math.round(14.58));

        System.out.println("Ceil of 14.28 is "+Math.ceil(14.28) );
        System.out.println("Floor of 14.28 is "+Math.floor(14.28) );








    }
}
