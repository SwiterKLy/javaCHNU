package Lab4;

import java.util.Scanner;

public class Lab4 {
    private double[] vector = null;

    public Lab4(double[] vector) {
        this.vector = vector;
    }

    public double mult(Lab4 anotherVector) {
        double s = 0;
        for (int i = 0; i < vector.length; i++) {
            s += vector[i] * anotherVector.vector[i];
        }
        return s;
    }

    public static double mult(Lab4 a, Lab4 b) {
        return a.mult(b);
    }

    public double add(Lab4 anotherVector) {
        double s = 0;
        for (int i = 0; i < vector.length; i++) {
            s += vector[i] + anotherVector.vector[i];
        }
        return s;
    }

    public static double add(Lab4 a, Lab4 b) {
        return a.add(b);
    }

    public double subtract(Lab4 anotherVector) {
        double s = 0;
        for (int i = 0; i < vector.length; i++) {
            s += vector[i] - anotherVector.vector[i];
        }
        return s;
    }

    public static double subtract(Lab4 a, Lab4 b) {
        return a.subtract(b);
    }

    public double mult2(double number) {
        double s = 0;
        for (int i = 0; i < vector.length; i++) {
            s += vector[i] * number;
        }
        return s;
    }

    public static double mult2(Lab4 a, double k) {
        return a.mult2(k);
    }

    public static void main(String[] args) {
        double[] a = {1, 2, 3, 4};
        double[] b = {1, 1, 1, 1};
        double[] c = {2, 2, 2, 2};

        System.out.print("Введіть число для множення на масив: ");
        Scanner sc = new Scanner(System.in);
        double k = sc.nextDouble();

        Lab4 v1 = new Lab4(a);
        Lab4 v2 = new Lab4(b);
        Lab4 v3 = new Lab4(c);

        System.out.println("v1*v2=" + v1.mult(v2));
        System.out.println("v1*v2=" + Lab4.mult(v1, v2));
        System.out.println("v1*v3=" + v1.mult(v3));

        System.out.println();
        System.out.println("v1+v2=" + v1.add(v2));
        System.out.println("v1+v2=" + Lab4.add(v1, v2));
        System.out.println("v1+v3=" + v1.add(v3));

        System.out.println();
        System.out.println("v1-v2=" + v1.subtract(v2));
        System.out.println("v1-v2=" + Lab4.subtract(v1, v2));
        System.out.println("v1-v3=" + v1.subtract(v3));

        System.out.println();
        System.out.println("v1*k=" + v1.mult2(k));
        System.out.println("v2*k=" + Lab4.mult2(v2, k));
        System.out.println("v3*k=" + v3.mult2(k));
    }
}
