package Enum;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;

enum Colors {
    GREEN, SAFFRON, BLUE, RED, YELLOW
}

enum Days {
    Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
}

enum City {
    Pune, Nagpur, Mumbai, Bengluru
}

class EnumSetTest {
    public static void main(String[] args) {

        Set<Colors> s1 = EnumSet.allOf(Colors.class);
        System.out.println("Name of Colors: " + s1);

        Set<Days> d1 = EnumSet.of(Days.Friday, Days.Monday, Days.Saturday);
        System.out.println("Name of Days: " + d1);

        Set<Colors> s2 = EnumSet.noneOf(Colors.class);
        System.out.println("Name of Colors : " + s2);

        List<City> l1 = List.of(City.Pune, City.Mumbai);
        Set<City> s4 = EnumSet.copyOf(l1);

        System.out.println("Elements are " + s4);
    }
}
