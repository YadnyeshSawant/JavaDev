package exceptionHandeling;

import java.io.IOException;
import java.util.Scanner;

class PayOutOFBoundException extends Exception {
    PayOutOFBoundException(int sal) {
        System.out.println("Org does not pay salary less than\t" + sal);
    }
}

public class Employee {
    String name;
    int sal;

    Employee(String name, int sal) {
        this.name = name;
        this.sal = sal;
    }

    void calculateSal() throws PayOutOFBoundException {
        if (sal < 3000) throw new PayOutOFBoundException(sal);
        else {
            int hra = (sal / 10) * 100;
            int va = (sal / 7) * 100;
            int da = (sal / 35) * 100;
            int grossSal = sal + hra + da + va;
            int pf = (grossSal / 5) * 100;
            int tds = (grossSal / 10) * 100;
            int netSal = grossSal - (pf + tds);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Employee e1 = new Employee("yadnyesh", 1240);
            Employee e2 = new Employee("Lalit", 45000);
            e1.calculateSal();
            e2.calculateSal();
        }
        catch (PayOutOFBoundException e) {
            System.out.println(e);
        }
    }

}
