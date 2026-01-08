package OOP.Static_KeyWord;

public class StaticVariableDemo2{
//    int count=0;
        static int count=0;
    StaticVariableDemo2()
    {
        count++;
        System.out.println(count);
    }

    public static void main(String[] args) {
        StaticVariableDemo2 s1 = new StaticVariableDemo2();
        StaticVariableDemo2 s2 = new StaticVariableDemo2();
        StaticVariableDemo2 s3 = new StaticVariableDemo2();

    }
}
