package ControlFlowStatement.If_else_Condition.Loops;

public class EvenOdd {
    public static void main(String[] args) {
        int n=50;
        for(int i=1;i<=50;i++)
        {
            if(i%2==0)
            {

                System.out.println(i+" is Even number");
            }
            if(i%2==1)
            {
                System.out.println(i+" is Odd Number");
            }
        }
    }
}
