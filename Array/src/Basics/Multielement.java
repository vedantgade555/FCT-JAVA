package Basics;

public class Multielement {
    public static void main(String[] args) {
//        int a[] = {5,10,15,20,25};
        int a[] = {10,20,30,40,50};
        System.out.println(a[0]);
        System.out.println(a[1]);
        System.out.println(a[2]);
        System.out.println(a[3]);
        System.out.println(a[4]);


        System.out.println("\n\nUsing Simple for loop");
        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }

        System.out.println("\n\nUsing for each loop");
        for(int i:a)
        {
            System.out.println(i);
        }


    }
}
