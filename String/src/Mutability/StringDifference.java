package Mutability;

public class StringDifference {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer("Java");

        for(int i=0;i<10000;i++)
        {
            sb.append("is easy");
        }

        System.out.println("Time taken by StringBuffer: "+(System.currentTimeMillis()-startTime));


        long startTime1 = System.currentTimeMillis();
        StringBuilder sb1 = new StringBuilder("Java");

        for(int i=0;i<10000;i++)
        {
            sb1.append("is easy");
        }

        System.out.println("Time taken by StringBuilder: "+(System.currentTimeMillis()-startTime1));
    }
}
