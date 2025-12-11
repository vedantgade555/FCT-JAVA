package Scanner;

import java.util.Scanner;

public class ScannerTestemo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner("My age is 21");

        boolean hasNextToken = sc.hasNext();
        System.out.println("Does my string contain next token: "+hasNextToken);
    }
}
