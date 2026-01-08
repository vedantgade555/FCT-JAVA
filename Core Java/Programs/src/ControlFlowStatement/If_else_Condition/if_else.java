package ControlFlowStatement.If_else_Condition;

public class if_else {
    public static void main(String[] args) {
        int year=2000;

        if((year%4==0)&&(year%1000!=0) || (year%400==0))
        {
            System.out.println("Year is Leap Year");
        }
        else
        {
            System.out.println("Year is not Leap Year");
        }
        System.out.println("Rest of the code...");
    }
}
