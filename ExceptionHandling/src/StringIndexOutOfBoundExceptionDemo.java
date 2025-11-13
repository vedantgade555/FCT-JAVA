public class StringIndexOutOfBoundExceptionDemo {
    public static void main(String[] args) {
        String a = "Vedant";
        System.out.println("Welcome to Exception Handling");
        try{
            System.out.println(a.charAt(7));
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
