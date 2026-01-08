package Exceptions;// If characher is store in string at that time we ant convert inot integer

public class NumberFormatExceptionDemo {
    public static void main(String[] args) {
        String s = "Vedant";
        System.out.println("Welcome to Exception Handling");
        try{
            int no  = Integer.parseInt(s);
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
