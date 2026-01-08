package ControlFlowStatement.If_else_Condition.Loops;

public class whileLoop {
    public static void main(String[] args) {

        int no=1234;
        int digit;
//        Split a digits of the number

        while(no!=0)
        {
            digit = no%10;
            no=no/10;
            System.out.print(digit);
        }

//        Reverse a number
        int rev;
        while(no!=0)
        {
            digit=no%10;
            no=no/10;
        }
    }
}
