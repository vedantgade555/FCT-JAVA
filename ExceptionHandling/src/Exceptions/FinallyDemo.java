package Exceptions;

public class FinallyDemo {
    public static void main(String[] args) {
        System.out.println("Welcome to Exception Handling");
        try{
            int data = 25/0;
            System.out.println(data);
        }catch (Exception e){
            System.out.println(e);
        }finally{
            System.out.println("Finally block always executed");
        }

    }
}
