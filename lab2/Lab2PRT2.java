import java.io.*;
import java.util.Scanner;

public class Lab2PRT2 {
    public static void main(String[] args) throws IOException
    {
       double angle = Double.parseDouble(args[0]);
        System.out.println("Ви ввели значеня кута: " + angle);
        System.out.println("Синус кута 30 градусів дорівнює: " + Math.sin(Math.toRadians(angle)));
        System.out.println("Косинус кута 30 градусів дорівнює: " + Math.cos(Math.toRadians(angle)));
    }
}
