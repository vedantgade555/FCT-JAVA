package ControlFlowStatement.If_else_Condition.Loops;

public class fibonaci {
    public static void main(String[] args) {
        int fib=10;
        int a=0;
        int b=1;
        System.out.println(a);
        System.out.println(b);
        for(int i=0;i<=fib;i++)
        {
           int  t=a;
            System.out.println(a+b);
            a=b;
            b= t+b;
        }
    }
}
