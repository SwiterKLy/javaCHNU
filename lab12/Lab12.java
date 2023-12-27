import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static int NumberOfPoints = 0;

    public static void main(String[] args) {
        createQuiz();
    }

    private static void createQuiz() {
        JFrame frame = new JFrame("Опитування");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        createWindow(cardPanel, "window1", "Питання №1", "Хто тримає цей район?", "Пес Патрон", "Кіт Барон");
        createWindow(cardPanel, "window2", "Питання №2", "Країна з найбільшим населенням", "Китай", "Індія", "США");
        createWindow(cardPanel, "window3", "Питання №3", "Предмет", "Java", "JS", "Scala");
        createWindow(cardPanel, "window4", "Тест пройдено", "Кількість балів: " + NumberOfPoints);

        frame.getContentPane().add(cardPanel);

        frame.setSize(300, 180);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void createWindow(JPanel cardPanel, String name, String question, String... answers) {
        JPanel window = new JPanel(new BorderLayout());

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        centerPanel.add(new JLabel(question));

        ButtonGroup buttonGroup = new ButtonGroup();

        for (String answer : answers) {
            JRadioButton radioButton = new JRadioButton(answer);
            buttonGroup.add(radioButton);
            centerPanel.add(radioButton);
        }

        window.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        JButton switchButton = new JButton("Далі");
        switchButton.addActionListener(new CustomActionListener(name, answers.length));
        bottomPanel.add(switchButton);

        window.add(bottomPanel, BorderLayout.SOUTH);

        cardPanel.add(window, name);
    }

    private static class CustomActionListener implements ActionListener {
        private final String nextWindowName;
        private final int pointsPerCorrectAnswer;

        public CustomActionListener(String nextWindowName, int pointsPerCorrectAnswer) {
            this.nextWindowName = nextWindowName;
            this.pointsPerCorrectAnswer = pointsPerCorrectAnswer;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            NumberOfPoints += pointsPerCorrectAnswer;
            cardLayout.show(cardPanel, nextWindowName);
        }
    }
}