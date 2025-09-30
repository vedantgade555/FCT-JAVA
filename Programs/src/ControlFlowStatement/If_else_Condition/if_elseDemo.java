package ControlFlowStatement.If_else_Condition;

public class if_elseDemo {
    public static void main(String[] args) {
        int billunit = 100;
        if(billunit<=100){
            System.out.println("Low Usuage");
        }
        else if((billunit>=101) && (billunit<=300))
        {
            System.out.println("Medium Usage");
        }
        else if(billunit>300)
        {
            System.out.println("High Usage");
        }
        else
        {
            System.out.println("Invalid Input" );
        }
    }
}
