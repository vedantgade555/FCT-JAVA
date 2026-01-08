package Scanner;

import java.util.Scanner;

public class ScannerTestemo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner("My age is 21");

        while(sc.hasNext()){
           if(sc.hasNextInt())
               System.out.println(sc.nextInt());
           else
               sc.next();
        }
    }
}
