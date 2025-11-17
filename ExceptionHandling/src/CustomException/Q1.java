package CustomException;

class InvalidAgeException extends Exception{
    public InvalidAgeException(String str){
        super(str);
    }
}
public class Q1 {

    public static void validate(int age) throws InvalidAgeException{
        if(age<18){
            throw new InvalidAgeException("Age not valid");
        }
        else{
            System.out.println("Valid Age");
        }
    }

    public static void main(String[] args) {
        int age=14;

        try{
            validate(age);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
