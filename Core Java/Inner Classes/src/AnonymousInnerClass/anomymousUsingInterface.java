package AnonymousInnerClass;

interface B {
    void run();
}

class TestAnonymousInterface{
    public static void main(String[] args) {
        B b1 = new B(){
            public void run(){
                System.out.println("Anonymous Class");
            }
        };
        b1.run();
    }
}
