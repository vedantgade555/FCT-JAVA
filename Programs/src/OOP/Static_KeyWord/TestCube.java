package OOP.Static_KeyWord;

class Calculate {
   static int cube(int x)
    {
        return x*x*x;
    }

}

public class TestCube
{
    public static void main(String[] args) {
        int res = Calculate.cube(5);

        System.out.println("Cube is "+res);
    }
}

