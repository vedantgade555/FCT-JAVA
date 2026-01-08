package MAPInterface;

import java.util.*;

class MapDemo {
    public static void main(String[] args) {
        HashMap m1 = new HashMap<>();
        m1.put(1, "Ram");
        m1.put(2, "Krishna");
        m1.put(3, "Bramha");
        m1.put(4, "Mahadev");

        System.out.println(m1);

      Set s = m1.entrySet();

        Iterator itr = s.iterator();

        while (itr.hasNext()) {

            Map.Entry entry = (Map.Entry)itr.next();

            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        m1.remove(2);
        System.out.println(m1);
        System.out.println(m1.keySet());
        System.out.println("Key 4 is present or not "+m1.containsKey(4));
        System.out.println("Ram is present or not "+m1.containsValue("Ram"));
        System.out.println("Get(2)"+m1.get(3));
        m1.replace(4,"Bholenath");
        System.out.println(m1);

        // LinkedHashMap

        LinkedHashMap m2 = new LinkedHashMap();
        m2.put(1, "Ram");
        m2.put(2, "Krishna");
        m2.put(3, "Bramha");
        m2.put(4, "Mahadev");

        System.out.println(m1);

        Set s1 = m2.entrySet();

        Iterator itr1 = s1.iterator();

        while (itr1.hasNext()) {

            Map.Entry entry1 = (Map.Entry)itr1.next();

            System.out.println(entry1.getKey() + " : " + entry1.getValue());
        }

        // TreeMap


        TreeMap m3 = new TreeMap();
        m3.put(1, "Ram");
        m3.put(2, "Krishna");
        m3.put(3, "Bramha");
        m3.put(4, "Mahadev");

        System.out.println(m3);

        Set s2 = m3.entrySet();

        Iterator itr2 = s2.iterator();

        while (itr2.hasNext()) {

            Map.Entry entry2 = (Map.Entry)itr2.next();

            System.out.println(entry2.getKey() + " : " + entry2.getValue());
        }
    }
}
