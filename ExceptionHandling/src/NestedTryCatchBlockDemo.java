public class NestedTryCatchBlockDemo {
    public static void main(String[] args) {
        try{
            int[] a = new int[5];
            try{
                a[6] = 100/0;
            }catch (ArithmeticException e) {
                System.out.println(e);
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println(e);
            }
            String s= null;
            System.out.println(s.length());

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
