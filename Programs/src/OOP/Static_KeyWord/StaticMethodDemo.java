package OOP.Static_KeyWord;

public class StaticMethodDemo {
    int emp_id=10;
    String ename="Rajesh";
    static String cname = "FCTP";

    StaticMethodDemo(int emp_id,String ename)
    {
        this.emp_id=emp_id;
        this.ename=ename;
    }
    void show()
    {
//        cname = "FCTB";
        System.out.println("Emp ID: "+emp_id+"EmpName :"+ename+"Company Name :"+cname);
    }

    static void change()
    {
        cname = "FCTS";
//        emp_id = 103;
//        ename = "Suraj";
//        emp_id and ename and does not access using this class bcoz they are not static
    }
    public static void main(String[] args) {
        StaticMethodDemo d1  = new StaticMethodDemo(101,"Sunil");
        StaticMethodDemo d2  = new StaticMethodDemo(102,"Rajesh");

        change();
        d1.show();
        d2.show();
    }
}

