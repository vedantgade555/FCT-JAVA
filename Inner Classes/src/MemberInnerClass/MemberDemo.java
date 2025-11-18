package MemberInnerClass;

class Outer {
    int a = 50;

    public void display() {
        System.out.println("Value: " + a);
    }

    class Inner {
        void show() {
            System.out.println("Method of inner class");
        }
    }

    public static void main(String[] args) {
        Outer o = new Outer();
        Outer.Inner in = o.new Inner();

        o.display();
        in.show();
    }
}
