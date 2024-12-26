package Trail;

import java.util.Scanner;

public class cal {
    int n,m;
    cal(int n,int m){
        this.n = n;
        this.m = m;

    }
    public int add(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Addition = "+(n+m));
        return n+m;
    }
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        cal c = new cal(n,m);
        c.add();
    }
}
