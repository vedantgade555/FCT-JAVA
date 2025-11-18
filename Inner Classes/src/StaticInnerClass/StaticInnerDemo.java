package StaticInnerClass;

public class StaticInnerDemo {
    static int data =100;

    static class Inner{

        void show(){
            System.out.println(data);
        }
    }

    public static void main(String[] args) {
        StaticInnerDemo.Inner d1 = new StaticInnerDemo.Inner();
        d1.show();
    }
}
