import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lab7 extends JFrame {
    JTextField inputField = new JTextField(20);
    JTextField outputField = new JTextField(20);
    JLabel inputLabel = new JLabel("Введіть текст:");
    JLabel outputLabel = new JLabel("Виведений текст:");
    JButton executeButton = new JButton("Виконати");

    Lab7() {
        super("Мітки та поля вводу/виводу");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        setSize(400, 200);
        inputField.setPreferredSize(new Dimension(200, 25));
        outputField.setPreferredSize(new Dimension(200, 25));
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(inputLabel, gbc);
        gbc.gridy = 1;
        inputPanel.add(inputField, gbc);
        JPanel outputPanel = new JPanel(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        outputPanel.add(outputLabel, gbc);
        gbc.gridy = 1;
        outputPanel.add(outputField, gbc);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(executeButton);
        executeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputField.setText("Кнопка натиснута");
            }
        });
        inputField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputField.setText("Введений текст: " + inputField.getText());
            }
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
        SwingUtilities.invokeLater(() -> {
            new Lab7().setVisible(true);
        });
    }
}
