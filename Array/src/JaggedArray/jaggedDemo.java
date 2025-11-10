package JaggedArray;

public class jaggedDemo {
    public static void main(String[] args) {
        int[][] jaggedArrray = {{1,2,3},{4,6},{7,8,9}};

        for(int i=0;i<jaggedArrray.length;i++)
        {
            for(int j=0;j<jaggedArrray[i].length;j++)
            {
                System.out.println(jaggedArrray[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
}
