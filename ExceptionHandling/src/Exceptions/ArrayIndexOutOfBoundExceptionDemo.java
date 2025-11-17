package Exceptions;

public class ArrayIndexOutOfBoundExceptionDemo {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        System.out.println("Welcome to Exception Handling");
        try{
            System.out.println(a[10]);
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
