package Enum;


import java.util.*;

public class EnumMapTest {
    public static void main(String[] args) {
        EnumMap<Colors,String> map = new EnumMap<Colors, String>(Colors.class);
        map.put(Colors.GREEN,"1");
        map.put(Colors.BLUE,"2");
        map.put(Colors.SAFFRON,"3");

        System.out.println(map);


    }
}
