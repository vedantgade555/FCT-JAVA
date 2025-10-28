package OOP.Polymorphism.FinalKeyword;
//Write a java program to display usage of final variable and final class
//it should include final constant class which contains final variable as PI
//next you have to use Pi to calculate area of circle in another class which
//is use to claculate area of circle.


final class Constants {
    final static double pi = 3.14;
}

class Circle
{
    public void area(int radius)
    {
        double result = Constants.pi*radius*radius;
        System.out.println("Area of circle is ; "+result);
    }

    public static void main(String[] args) {
        Circle c1 = new Circle();
        c1.area(5);
    }
}
