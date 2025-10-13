package OOP.thisKeyWord;

class ThisConDemo {
    TestThis obj;

    public ThisConDemo(TestThis obj) {
        this.obj = obj;
    }

    void info() {
        System.out.println("Rahul: " + obj.data);
    }
}

class Rohit {
    TestThis obj1;  // ✅ Instance variable added

    public Rohit(TestThis obj1) {
        this.obj1 = obj1;
    }

    void info() {
        System.out.println("Rohit: " + obj1.data);
    }
}

class TestThis {
    int data = 50;

    TestThis() {
        ThisConDemo d1 = new ThisConDemo(this);
        d1.info();

        Rohit d2 = new Rohit(this);
        d2.info();
    }

    public static void main(String[] args) {
        TestThis a1 = new TestThis();
    }
}
