package LocalInnerClass;

class Out {
    int a = 50;

    public void display() {
        System.out.println("Value: " + a);

        class LocalInner {
            void show() {
                System.out.println("Method of inner class");
            }
        }

        LocalInner l1 = new LocalInner();
        l1.show();
    }



    public static void main(String[] args) {
        Out o = new Out();
        o.display();
    }
}
