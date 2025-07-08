package GAME;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TypingGameMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame mainFrame = new JFrame("Key Fusion Levels");
            mainFrame.setSize(800, 600);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setLocationRelativeTo(null);

            // Set the background gradient for the main panel
            JPanel menuPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2d = (Graphics2D) g;
                    Color color1 = new Color(255, 223, 186); // Light peach
                    Color color2 = new Color(255, 192, 203); // Light pink
                    GradientPaint gradient = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
                    g2d.setPaint(gradient);
                    g2d.fillRect(0, 0, getWidth(), getHeight());
                }
            };
            menuPanel.setLayout(new GridLayout(4, 1, 10, 10));
            menuPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

            // Title label with a vibrant color
            JLabel titleLabel = new JLabel("Key Fusion", JLabel.CENTER);
            titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
            titleLabel.setForeground(new Color(255, 69, 0)); // Red-orange color

            // Buttons styling with hover effect
            JButton level1Button = createButton("Level 1: Easy");
            JButton level2Button = createButton("Level 2: Medium");
            JButton level3Button = createButton("Level 3: Hard");

            level1Button.addActionListener(e -> startLevel(new Level1()));
            level2Button.addActionListener(e -> startLevel(new Level2()));
            level3Button.addActionListener(e -> startLevel(new Level3()));

            menuPanel.add(titleLabel);
            menuPanel.add(level1Button);
            menuPanel.add(level2Button);
            menuPanel.add(level3Button);

            mainFrame.add(menuPanel);
            mainFrame.setVisible(true);
        });
    }

    private static JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        button.setBackground(new Color(60, 179, 113)); // Green background
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(new Color(34, 139, 34), 2)); // Dark green border

        // Add hover effect
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(new Color(34, 139, 34)); // Dark green when hovered
            }
            public void mouseExited(MouseEvent evt) {
                button.setBackground(new Color(60, 179, 113)); // Back to original green
            }
        });
        return button;
    }

    private static void startLevel(JFrame level) {
        level.setVisible(true);
    }
}


//package GAME;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class TypingGameMain {
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            JFrame mainFrame = new JFrame("Typing Game Levels");
//            mainFrame.setSize(800, 600);
//            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            mainFrame.setLocationRelativeTo(null);
//
//            JPanel menuPanel = new JPanel();
//            menuPanel.setLayout(new GridLayout(4, 1, 10, 10));
//            menuPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
//
//            JLabel titleLabel = new JLabel("Typing Game", JLabel.CENTER);
//            titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
//
//            JButton level1Button = new JButton("Level 1: Easy");
//            JButton level2Button = new JButton("Level 2: Medium");
//            JButton level3Button = new JButton("Level 3: Hard");
//
//            level1Button.setFont(new Font("Arial", Font.PLAIN, 18));
//            level2Button.setFont(new Font("Arial", Font.PLAIN, 18));
//            level3Button.setFont(new Font("Arial", Font.PLAIN, 18));
//
//            level1Button.addActionListener(e -> startLevel(new Level1()));
//            level2Button.addActionListener(e -> startLevel(new Level2()));
//            level3Button.addActionListener(e -> startLevel(new Level3()));
//
//            menuPanel.add(titleLabel);
//            menuPanel.add(level1Button);
//            menuPanel.add(level2Button);
//            menuPanel.add(level3Button);
//
//            mainFrame.add(menuPanel);
//            mainFrame.setVisible(true);
//        });
//    }
//
//    private static void startLevel(JFrame level) {
//        level.setVisible(true);
//    }
//}