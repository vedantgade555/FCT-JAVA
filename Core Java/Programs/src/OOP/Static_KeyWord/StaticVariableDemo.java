package OOP.Static_KeyWord;

public class StaticVariableDemo {
    int emp_id;
    String ename;
     static String cname = "FCTP";

     StaticVariableDemo(int emp_id,String ename)
     {
         this.emp_id=emp_id;
         this.ename=ename;
     }
     void show()
     {
         System.out.println("Emp ID: "+emp_id+"EmpName :"+ename+"Company Name :"+cname);
     }

    public static void main(String[] args) {
        StaticVariableDemo d1  = new StaticVariableDemo(101,"Sunil");
        StaticVariableDemo d2  = new StaticVariableDemo(102,"Rajesh");

        d1.show();
        d2.show();

    }
}
