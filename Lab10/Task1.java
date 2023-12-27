package Lab10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class Task1 extends JFrame {
    private JTextField inputFieldFamily = new JTextField(20);
    private JTextField inputFieldPhoneNumber = new JTextField(20);
    private JTextField outputFieldCount = new JTextField(2);
    private JLabel inputLabelFamily = new JLabel("Введіть фамілію:");
    private JLabel inputLabelPhoneNumber = new JLabel("Введіть телефон:");
    private JLabel outputLabelCount = new JLabel("Кількість записів:");
    private JButton executeButton = new JButton("Виконати");
    private JButton printButton = new JButton("Друкувати");
    private int count = 0;

    public Task1() {
        super("Мітки та поля вводу/виводу");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        inputFieldFamily.getDocument().addDocumentListener((SimpleDocumentListener) e -> {
            boolean fieldsNotEmpty = !inputFieldFamily.getText().isEmpty() &&
                    !inputFieldPhoneNumber.getText().isEmpty();
            executeButton.setEnabled(fieldsNotEmpty);
        });
        inputFieldPhoneNumber.getDocument().addDocumentListener((SimpleDocumentListener) e -> {
            boolean fieldsNotEmpty = !inputFieldFamily.getText().isEmpty() &&
                    !inputFieldPhoneNumber.getText().isEmpty();
            executeButton.setEnabled(fieldsNotEmpty);
        });
        outputFieldCount.setEnabled(false);

        setSize(400, 270);
        inputFieldFamily.setPreferredSize(new Dimension(200, 25));
        inputFieldPhoneNumber.setPreferredSize(new Dimension(200, 25));

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(inputLabelFamily, gbc);
        gbc.gridy = 1;
        inputPanel.add(inputFieldFamily, gbc);

        JPanel outputPanel = new JPanel(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        outputPanel.add(inputLabelPhoneNumber, gbc);
        gbc.gridy = 1;
        outputPanel.add(inputFieldPhoneNumber, gbc);
        gbc.gridy = 2;
        outputPanel.add(outputLabelCount, gbc);
        gbc.gridy = 3;
        outputPanel.add(outputFieldCount, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ArrayList<String> AllPeople = new ArrayList<>();
        ArrayList<String> PhoneNumbers = new ArrayList<>();
        executeButton.setEnabled(false);
        buttonPanel.add(executeButton);
        buttonPanel.add(printButton);

        executeButton.addActionListener(e -> {
            AllPeople.add(inputFieldFamily.getText());
            PhoneNumbers.add(inputFieldPhoneNumber.getText());
            inputFieldFamily.setText("");
            inputFieldPhoneNumber.setText("");
            count++;
            outputFieldCount.setText("" + count);
        });

        printButton.addActionListener(e -> {
            System.out.println(AllPeople);
            System.out.println(PhoneNumbers);
        });

        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(inputPanel, BorderLayout.NORTH);
        c.add(outputPanel, BorderLayout.CENTER);
        c.add(buttonPanel, BorderLayout.SOUTH);

        WindowListener wndCloser = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        addWindowListener(wndCloser);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Task1().setVisible(true));
    }
}
