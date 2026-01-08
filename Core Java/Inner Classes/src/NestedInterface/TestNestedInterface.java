package NestedInterface;

interface outer {
    void show();
    interface inner {
        void display();   // method of nested interface
    }
}

public class TestNestedInterface implements outer.inner {

    // Implementing the nested interface method
    @Override
    public void display() {
        System.out.println("Overriding method of nested interface");
    }

    public static void main(String[] args) {
        outer.inner obj1 = new TestNestedInterface();
        obj1.display();  // Only display() can be called
    }
}
