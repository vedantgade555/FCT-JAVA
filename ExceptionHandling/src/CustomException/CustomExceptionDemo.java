package CustomException;

class UserException extends Exception{
    public UserException(String str){
        super(str);
    }
}
public class CustomExceptionDemo {
    public static void main(String[] args) {
        try{
            throw new UserException("This is my custom Exception");
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("Rest of the code");
    }
}
