package ControlFlowStatement.If_else_Condition;

public class Switch_Case {
    public static void main(String[] args) {
        System.out.println("s1.Cricket");
        System.out.println("s2.Football");
        System.out.println("s3.Kabbdi");
        System.out.println("s4.kho-kho");
        System.out.println("s5.Hockey");
        String ch="s1";

//        switch (ch)
//        {
//            case 1:
//                System.out.println("My Fav sports is Cricket");
//                break;
//
//            case 2:
//                System.out.println("My Fav sports is Football");
//                break;
//
//            case 3:
//                System.out.println("My Fav sports is Kabbdi");
//                break;
//
//            case 4:
//                System.out.println("My Fav sports is kho-kho");
//                break;
//
//            case 5:
//                System.out.println("My Fav sports is Hockey");
//                break;
//
//            default:
//                System.out.println("Invalid Input");
//                break;
//        }



        switch (ch)
        {
            case "s1":
                System.out.println("My Fav sports is Cricket");
                break;

            case "s2":
                System.out.println("My Fav sports is Football");
                break;

            case "s3":
                System.out.println("My Fav sports is Kabbdi");
                break;

            case "s4":
                System.out.println("My Fav sports is kho-kho");
                break;

            case "s5":
                System.out.println("My Fav sports is Hockey");
                break;

            default:
                System.out.println("Invalid Input");
                break;
        }

    }
}
