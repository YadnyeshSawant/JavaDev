package revision;

import java.util.Scanner;

abstract class shape {
    float pi = 3.14F;
    abstract float area(float radius);
    abstract void display(float area);
}
public class abst extends shape{

    @Override
    float area(float radius) {
        return pi * radius * radius;
    }

    @Override
    void display(float area) {
        System.out.println("Area = "+area);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the radius");
        float r = sc.nextFloat();
        abst ab = new abst();
        float ar = ab.area(r);
        ab.display(ar);

    }

}