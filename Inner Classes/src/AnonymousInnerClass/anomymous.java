package AnonymousInnerClass;

abstract class A {
    abstract void run();
}

class TestAnonymous{
    public static void main(String[] args) {
        A a1 = new A(){
            void run(){
                System.out.println("Anonymous Class");
            }
        };
        a1.run();
    }
}
