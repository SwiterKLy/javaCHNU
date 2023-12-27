import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;

public class Lab11 extends JFrame {
    JTextArea txt;

    JLabel inputLabelFamily = new JLabel("Функція: y=A*sqr(x)*sin(A*x)");

    JTextField AField, hField, countField;

    Lab11() {
        super("Лабораторна робота №11");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        setSize(500, 250);
        Container c = getContentPane();
        JPanel pane = new JPanel();
        c.add(pane, BorderLayout.CENTER);

        pane.add(inputLabelFamily);

        pane.add(new JLabel("A:"));
        AField = new JTextField(5);
        pane.add(AField);

        pane.add(new JLabel("h:"));
        hField = new JTextField(5);
        pane.add(hField);

        pane.add(new JLabel("Кількість:"));
        countField = new JTextField(5);
        pane.add(countField);

        JButton calculateButton = new JButton("Обчислити");
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });
        pane.add(calculateButton);

        pane.add(txt = new JTextArea(14, 40));
        JScrollPane scroll = new JScrollPane(txt);
        pane.add(scroll);

        WindowListener wndCloser = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        addWindowListener(wndCloser);
    }

    private void calculate() {
        try {
            double A = Double.parseDouble(AField.getText());
            double h = Double.parseDouble(hField.getText());
            int numberOfPoints = Integer.parseInt(countField.getText());

            for (int i = 0; i < numberOfPoints; i++) {
                double x = i * h;
                double result = A * Math.sqrt(x) * Math.sin(A * x);

                txt.append("Y(" + A + ", " + x +") = " + result + "\n");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Некоректні вхідні дані. Введіть числа для A та h та кількість значень");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Lab11().setVisible(true);
            }
        });
    }
}