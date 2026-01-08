package Scanner;

import java.util.Scanner;

public class ScannerTestemo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner("Hello from Vedant Gade");

        while(sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }
    }
}
