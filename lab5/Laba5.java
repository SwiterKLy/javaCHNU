package Lab5;

import javax.swing.*;
import java.awt.*;

public class Laba5 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Task2 Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(190, 100);
        DoubleVector vector = new DoubleVector();
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        JLabel label1 = new JLabel("Вивід 1: " + vector.getResult1());
        JLabel label2 = new JLabel("Вивід 2: " + vector.isResult2());
        JLabel label3 = new JLabel("Вивід 3: " + vector.getResult3());
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.setVisible(true);
    }
    static class DoubleVector {
        private int result1 = 10;
        private boolean result2 = true;
        private String result3 = "Лабораторна 5";

        public int getResult1() {
            return result1;
        }

        public boolean isResult2() {
            return result2;
        }

        public String getResult3() {
            return result3;
        }
    }
}
