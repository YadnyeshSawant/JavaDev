package GAME;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public abstract class TypingGameLevel extends JFrame {
    protected JTextArea passageArea;
    protected JTextArea inputArea;
    protected JLabel timerLabel;
    protected JLabel resultsLabel;
    protected JButton startButton;
    protected JButton finishButton;
    protected Map<Character, Character> keyMapping;

    protected String originalPassage;
    protected long startTime;
    protected Timer timer;
    protected int timeLimit;
    private int elapsedSeconds = 0;

    public TypingGameLevel(String title, String passage, int timeLimit) {
        setTitle(title);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        this.originalPassage = passage;
        this.timeLimit = timeLimit;

        initializeKeyMapping();
        setupUI();
    }

    private void initializeKeyMapping() {
        keyMapping = new HashMap<>();
        keyMapping.put('a', 'g'); keyMapping.put('b', 'k'); keyMapping.put('c', 'm');
        keyMapping.put('d', 'r'); keyMapping.put('e', 't'); keyMapping.put('f', 'z');
        keyMapping.put('g', 'a'); keyMapping.put('h', 'o'); keyMapping.put('i', 'e');
        keyMapping.put('j', 'y'); keyMapping.put('k', 'b'); keyMapping.put('l', 'u');
        keyMapping.put('m', 'c'); keyMapping.put('n', 'd'); keyMapping.put('o', 'h');
        keyMapping.put('p', 'x'); keyMapping.put('q', 'w'); keyMapping.put('r', 'f');
        keyMapping.put('s', 'l'); keyMapping.put('t', 'n'); keyMapping.put('u', 'p');
        keyMapping.put('v', 'q'); keyMapping.put('w', 'v'); keyMapping.put('x', 'j');
        keyMapping.put('y', 's'); keyMapping.put('z', 'i'); keyMapping.put(' ', ' ');
    }

    private void setupUI() {
        // Passage Area Styling
        passageArea = new JTextArea(originalPassage);
        passageArea.setEditable(false);
        passageArea.setFocusable(false);
        passageArea.setFont(new Font("Serif", Font.BOLD, 18));
        passageArea.setWrapStyleWord(true);
        passageArea.setLineWrap(true);
        passageArea.setBackground(new Color(240, 248, 255)); // Light blue background
        passageArea.setForeground(new Color(0, 51, 102)); // Dark blue text color
        passageArea.setBorder(BorderFactory.createTitledBorder("Passage"));
        passageArea.setFont(new Font("Arial", Font.PLAIN, 20));;

        // Input Area Styling
        inputArea = new JTextArea();
        inputArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        inputArea.setLineWrap(true);
        inputArea.setWrapStyleWord(true);
        inputArea.setEnabled(false);
        inputArea.setBackground(new Color(255, 255, 240)); // Light yellow background
        inputArea.setForeground(new Color(0, 51, 51)); // Dark greenish text color
        inputArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (keyMapping.containsKey(keyChar)) {
                    e.consume();
                    inputArea.append(String.valueOf(keyMapping.get(keyChar)));
                }
            }
        });

        JScrollPane inputScrollPane = new JScrollPane(inputArea);
        inputScrollPane.setBorder(BorderFactory.createTitledBorder("Type Here"));

        // Timer Label Styling
        timerLabel = new JLabel("Time: 0:00");
        timerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        timerLabel.setForeground(new Color(255, 69, 0)); // Red-orange color

        // Results Label Styling
        resultsLabel = new JLabel(" ");
        resultsLabel.setFont(new Font("Arial", Font.BOLD, 25));
        resultsLabel.setForeground(new Color(34, 139, 34)); // Green color

        // Start and Finish Buttons Styling
        startButton = new JButton("START");
        finishButton = new JButton("Finish");
        finishButton.setEnabled(false);

        startButton.setBackground(new Color(60, 179, 113));
        startButton.setForeground(Color.BLACK);
        startButton.setFont(new Font("Arial", Font.BOLD, 20));
        startButton.setPreferredSize(new Dimension(150, 50));

        finishButton.setBackground(new Color(46, 186, 133));
        finishButton.setForeground(Color.BLACK);
        finishButton.setFont(new Font("Arial", Font.BOLD, 20));
        finishButton.setPreferredSize(new Dimension(150, 50));

        startButton.addActionListener(e -> startGame());
        finishButton.addActionListener(e -> finishGame());

        JPanel bottomPanel = new JPanel(new BorderLayout());
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        buttonsPanel.add(startButton);
        buttonsPanel.add(finishButton);
        bottomPanel.add(timerLabel, BorderLayout.NORTH);
        bottomPanel.add(buttonsPanel, BorderLayout.CENTER);
        bottomPanel.add(resultsLabel, BorderLayout.SOUTH);

        add(passageArea, BorderLayout.NORTH);
        add(inputScrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void startGame() {
        inputArea.setText("");
        inputArea.setEnabled(true);
        startButton.setEnabled(false);
        finishButton.setEnabled(true);
        resultsLabel.setText("");

        startTime = System.currentTimeMillis();
        elapsedSeconds = 0;
        timer = new Timer(1000, e -> updateTimer());
        timer.start();
    }

    private void updateTimer() {
        elapsedSeconds++;
        int remainingTime = timeLimit - elapsedSeconds;
        int minutes = remainingTime / 60;
        int seconds = remainingTime % 60;
        timerLabel.setText(String.format("Time: %d:%02d", minutes, seconds));

        if (remainingTime <= 0) {
            timer.stop();
            finishGame();
            JOptionPane.showMessageDialog(this, "Time's up!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
        }
    }

//    private void finishGame() {
//
//        if (timer != null) timer.stop(); // Stop the timer
//
//        inputArea.setEnabled(false); // Disable the input area
//        finishButton.setEnabled(false); // Disable the Finish button
//
//        String userInput = inputArea.getText(); // Get the user's input
//        String decodedInput = decodeInput(userInput); // Decode the input based on the key mapping
//        double accuracy = calculateAccuracy(originalPassage, decodedInput); // Calculate accuracy
//
//        long endTime = System.currentTimeMillis();
//        long totalTimeTaken = (endTime - startTime) / 1000; // Time in seconds
//        int minutes = (int) (totalTimeTaken / 60);
//        int seconds = (int) (totalTimeTaken % 60);
//
//        // Prepare the result message
//        String resultMessage = String.format(
//                "<html><div style='text-align: center;'>" +
//                        "<span style='font-size: 18px; font-family: Arial; color: #333;'>Your Typing Accuracy:</span><br>" +
//                        "<span style='font-size: 28px; font-family: Verdana; color: %s;'>%.2f%%</span><br>" +
//                        "<span style='font-size: 18px; font-family: Arial; color: #333;'>Time Taken:</span><br>" +
//                        "<span style='font-size: 28px; font-family: Verdana; color: #0066cc;'>%d:%02d</span></div></html>",
//                accuracy > 50 ? "green" : "red", // Set color based on accuracy
//                accuracy, minutes, seconds
//        );
//
//        // Create a custom JLabel with the styled message
//        JLabel messageLabel = new JLabel(resultMessage);
//        messageLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center-align the text
//
//        // Show the custom popup dialog
//        JOptionPane.showMessageDialog(
//                this,                // Parent component
//                messageLabel,        // Styled JLabel as the message
//                "Game Result",       // Title
//                JOptionPane.PLAIN_MESSAGE // Use plain message type for custom styling
//        );
//
//        // Optionally update the result label on the UI
//        resultsLabel.setText(String.format("Accuracy: %.2f%%, Time Taken: %d:%02d", accuracy, minutes, seconds));
//
//        // Change the label color based on accuracy
//        if (accuracy > 50) {
//            resultsLabel.setForeground(Color.GREEN);
//        } else {
//            resultsLabel.setForeground(Color.RED);
//        }
//
//    }

    protected void finishGame() {
        if (timer != null) timer.stop(); // Stop the timer

        inputArea.setEnabled(false); // Disable the input area
        finishButton.setEnabled(false); // Disable the Finish button

        String userInput = inputArea.getText(); // Get the user's input
        String decodedInput = decodeInput(userInput); // Decode the input based on the key mapping
        double accuracy = calculateAccuracy(originalPassage, decodedInput); // Calculate accuracy

        long endTime = System.currentTimeMillis();
        long totalTimeTaken = (endTime - startTime) / 1000; // Time in seconds
        int minutes = (int) (totalTimeTaken / 60);
        int seconds = (int) (totalTimeTaken % 60);

        // Create the result message with HTML styling
        String resultMessage = String.format(
                "<html><div style='text-align: center;'>" +
                        "<span style='font-size: 20px; font-family: Arial; color: #333;'>Your Typing Accuracy:</span><br>" +
                        "<span style='font-size: 32px; font-family: Verdana; color: %s;'>%.2f%%</span><br><br>" +
                        "<span style='font-size: 20px; font-family: Arial; color: #333;'>Time Taken:</span><br>" +
                        "<span style='font-size: 28px; font-family: Verdana; color: #0066cc;'>%d:%02d</span></div></html>",
                accuracy > 50 ? "green" : "red", // Set color based on accuracy
                accuracy, minutes, seconds
        );

        // Create a custom JDialog
        JDialog resultDialog = new JDialog(this, "Game Result", true);
        resultDialog.setSize(400, 250);
        resultDialog.setLayout(new BorderLayout());
        resultDialog.setLocationRelativeTo(this); // Center it relative to the parent window

        // Create a JLabel for the message
        JLabel messageLabel = new JLabel(resultMessage);
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Add the message label to the dialog
        resultDialog.add(messageLabel, BorderLayout.CENTER);

        // Automatically close the dialog after 5 seconds
        Timer closeTimer = new Timer(5000, e -> resultDialog.dispose());
        closeTimer.setRepeats(false);
        closeTimer.start();

        // Show the dialog
        resultDialog.setVisible(true);

        // Optionally update the result label on the UI
        resultsLabel.setText(String.format("Accuracy: %.2f%%, Time Taken: %d:%02d", accuracy, minutes, seconds));

        // Change the label color based on accuracy
        if (accuracy > 50) {
            resultsLabel.setForeground(Color.GREEN);
        } else {
            resultsLabel.setForeground(Color.RED);
        }
    }


    private void calculateResults() {
        String userInput = inputArea.getText();
        String decodedInput = decodeInput(userInput);
        double accuracy = calculateAccuracy(originalPassage, decodedInput);

        long endTime = System.currentTimeMillis();
        long totalTimeTaken = (endTime - startTime) / 1000;
        int minutes = (int) (totalTimeTaken / 60);
        int seconds = (int) (totalTimeTaken % 60);

        resultsLabel.setText(String.format("Accuracy: %.2f%%, Time Taken: %d:%02d", accuracy, minutes, seconds));

        // Change font color based on accuracy
        if (accuracy > 50) {
            resultsLabel.setForeground(new Color(34, 139, 34)); // Green if good accuracy
        } else {
            resultsLabel.setForeground(new Color(255, 69, 0)); // Red if poor accuracy
        }
    }

    private String decodeInput(String input) {
        StringBuilder decoded = new StringBuilder();
        for (char c : input.toCharArray()) {
            decoded.append(keyMapping.entrySet().stream()
                    .filter(entry -> entry.getValue() == c)
                    .map(Map.Entry::getKey)
                    .findFirst()
                    .orElse(c));
        }
        return decoded.toString();
    }

    private double calculateAccuracy(String original, String typed) {
        int correct = 0;
        for (int i = 0; i < Math.min(original.length(), typed.length()); i++) {
            if (original.charAt(i) == typed.charAt(i)) correct++;
        }
        return ((double) correct / original.length()) * 100;
    }
}



//package GAME;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.util.HashMap;
//import java.util.Map;
//
//public abstract class TypingGameLevel extends JFrame {
//    protected JTextArea passageArea;
//    protected JTextArea inputArea;
//    protected JLabel timerLabel;
//    protected JLabel resultsLabel;
//    protected JButton startButton;
//    protected JButton finishButton;
//    protected Map<Character, Character> keyMapping;
//
//    protected String originalPassage;
//    protected long startTime;
//    protected Timer timer;
//    protected int timeLimit;
//    private int elapsedSeconds = 0;
//
//    public TypingGameLevel(String title, String passage, int timeLimit) {
//        setTitle(title);
//        setSize(800, 600);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setLocationRelativeTo(null);
//        setLayout(new BorderLayout());
//
//        this.originalPassage = passage;
//        this.timeLimit = timeLimit;
//
//        initializeKeyMapping();
//        setupUI();
//    }
//
//    private void initializeKeyMapping() {
//        keyMapping = new HashMap<>();
//        keyMapping.put('a', 'g'); keyMapping.put('b', 'k'); keyMapping.put('c', 'm');
//        keyMapping.put('d', 'r'); keyMapping.put('e', 't'); keyMapping.put('f', 'z');
//        keyMapping.put('g', 'a'); keyMapping.put('h', 'o'); keyMapping.put('i', 'e');
//        keyMapping.put('j', 'y'); keyMapping.put('k', 'b'); keyMapping.put('l', 'u');
//        keyMapping.put('m', 'c'); keyMapping.put('n', 'd'); keyMapping.put('o', 'h');
//        keyMapping.put('p', 'x'); keyMapping.put('q', 'w'); keyMapping.put('r', 'f');
//        keyMapping.put('s', 'l'); keyMapping.put('t', 'n'); keyMapping.put('u', 'p');
//        keyMapping.put('v', 'q'); keyMapping.put('w', 'v'); keyMapping.put('x', 'j');
//        keyMapping.put('y', 's'); keyMapping.put('z', 'i'); keyMapping.put(' ', ' ');
//    }
//
//    private void setupUI() {
//        passageArea = new JTextArea(originalPassage);
//        passageArea.setEditable(false);
//        passageArea.setFocusable(false);
//        passageArea.setFont(new Font("Serif", Font.BOLD, 18));
//        passageArea.setWrapStyleWord(true);
//        passageArea.setLineWrap(true);
//        passageArea.setForeground(Color.BLACK);
//        passageArea.setBorder(BorderFactory.createTitledBorder("Passage"));
//
//        inputArea = new JTextArea();
//        inputArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
//        inputArea.setLineWrap(true);
//        inputArea.setWrapStyleWord(true);
//        inputArea.setEnabled(false);
//        inputArea.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                char keyChar = e.getKeyChar();
//                if (keyMapping.containsKey(keyChar)) {
//                    e.consume();
//                    inputArea.append(String.valueOf(keyMapping.get(keyChar)));
//                }
//            }
//        });
//
//        JScrollPane inputScrollPane = new JScrollPane(inputArea);
//        inputScrollPane.setBorder(BorderFactory.createTitledBorder("Type Here"));
//
//        timerLabel = new JLabel("Time: 0:00");
//        resultsLabel = new JLabel(" ");
//        resultsLabel.setFont(new Font("Arial", Font.BOLD, 14));
//
//        startButton = new JButton("Start");
//        finishButton = new JButton("Finish");
//        finishButton.setEnabled(false);
//
//        startButton.addActionListener(e -> startGame());
//        finishButton.addActionListener(e -> finishGame());
//
//        JPanel bottomPanel = new JPanel(new BorderLayout());
//        JPanel buttonsPanel = new JPanel(new FlowLayout());
//        buttonsPanel.add(startButton);
//        buttonsPanel.add(finishButton);
//        bottomPanel.add(timerLabel, BorderLayout.NORTH);
//        bottomPanel.add(buttonsPanel, BorderLayout.CENTER);
//        bottomPanel.add(resultsLabel, BorderLayout.SOUTH);
//
//        add(passageArea, BorderLayout.NORTH);
//        add(inputScrollPane, BorderLayout.CENTER);
//        add(bottomPanel, BorderLayout.SOUTH);
//    }
//
//    private void startGame() {
//        inputArea.setText("");
//        inputArea.setEnabled(true);
//        startButton.setEnabled(false);
//        finishButton.setEnabled(true);
//        resultsLabel.setText("");
//
//        startTime = System.currentTimeMillis();
//        elapsedSeconds = 0;
//        timer = new Timer(1000, e -> updateTimer());
//        timer.start();
//    }
//
//    private void updateTimer() {
//        elapsedSeconds++;
//        int remainingTime = timeLimit - elapsedSeconds;
//        int minutes = remainingTime / 60;
//        int seconds = remainingTime % 60;
//        timerLabel.setText(String.format("Time: %d:%02d", minutes, seconds));
//
//        if (remainingTime <= 0) {
//            timer.stop();
//            finishGame();
//            JOptionPane.showMessageDialog(this, "Time's up!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
//        }
//    }
//
//    private void finishGame() {
//        if (timer != null) timer.stop();
//        inputArea.setEnabled(false);
//        finishButton.setEnabled(false);
//        calculateResults();
//    }
//
//    private void calculateResults() {
//        String userInput = inputArea.getText();
//        String decodedInput = decodeInput(userInput);
//        double accuracy = calculateAccuracy(originalPassage, decodedInput);
//
//        long endTime = System.currentTimeMillis();
//        long totalTimeTaken = (endTime - startTime) / 1000;
//        int minutes = (int) (totalTimeTaken / 60);
//        int seconds = (int) (totalTimeTaken % 60);
//
//        resultsLabel.setText(String.format("Accuracy: %.2f%%, Time Taken: %d:%02d", accuracy, minutes, seconds));
//
//        // Change font color based on accuracy
//        if (accuracy > 50) {
//            resultsLabel.setForeground(Color.GREEN);
//        } else {
//            resultsLabel.setForeground(Color.RED);
//        }
//    }
//
//
//    private String decodeInput(String input) {
//        StringBuilder decoded = new StringBuilder();
//        for (char c : input.toCharArray()) {
//            decoded.append(keyMapping.entrySet().stream()
//                    .filter(entry -> entry.getValue() == c)
//                    .map(Map.Entry::getKey)
//                    .findFirst()
//                    .orElse(c));
//        }
//        return decoded.toString();
//    }
//
//    private double calculateAccuracy(String original, String typed) {
//        int correct = 0;
//        for (int i = 0; i < Math.min(original.length(), typed.length()); i++) {
//            if (original.charAt(i) == typed.charAt(i)) correct++;
//        }
//        return ((double) correct / original.length()) * 100;
//    }
//}
//
//
//
