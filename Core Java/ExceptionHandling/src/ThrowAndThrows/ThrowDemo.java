package ThrowAndThrows;

public class ThrowDemo  {
    public static void valiate(int age){
        if(age<18){
            throw new NullPointerException("This Person is not allow to vote");
        }
        else
            System.out.println("Valid Voting Age");
    }


    public static void main(String[] args) {
        try{
            valiate(14);
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println("Rest of the code...");
    }
}
