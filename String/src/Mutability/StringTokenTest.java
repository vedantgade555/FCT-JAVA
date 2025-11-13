package Mutability;

import java.util.StringTokenizer;

public class StringTokenTest {
    public static void main(String[] args) {
        String s1 = "Have,a,nice,day,dear,all";

        StringTokenizer st = new StringTokenizer(s1);

        while(st.hasMoreTokens())
        {
            System.out.println(st.nextToken(","));
        }
    }
}
