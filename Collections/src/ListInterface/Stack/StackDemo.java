package ListInterface.Stack;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        boolean res = st.empty();

        System.out.println("Is Stack Empty: "+res);
        st.push(5);
        st.push(56);
        st.push(5);
        st.push(29);
        st.push(31);

        System.out.println("Elements of stack: "+st);
        st.push(55);
        System.out.println(st);
        st.pop();
        System.out.println(st);

        System.out.println("Peek of stack is : "+st.peek());
        System.out.println("Index of 5 is "+st.search(5));
        System.out.println("Index of 77 is "+st.search(77));


    }
}
