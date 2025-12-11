package Scanner;

import java.util.Scanner;

public class ScannerTestemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner("Hello from Vedant Gade");

        while(sc.hasNext()){
            System.out.println(sc.next());
        }
    }
}
