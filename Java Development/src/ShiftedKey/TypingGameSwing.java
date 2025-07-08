//package shiftedKey;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.util.HashMap;
//import java.util.Map;
//
//public class TypingGameSwing extends JFrame {
//    private final JTextArea passageArea;
//    private final JTextArea inputArea;
//    private final JLabel timerLabel;
//    private final JLabel resultsLabel;
//    private final JButton startButton;
//    private final JButton finishButton;
//    private final Map<Character, Character> keyMapping;
//
//    private String originalPassage = "Freston is a Neolithic causewayed enclosure at an archaeological site near the village of Freston in Suffolk, England. The Neolithic enclosure was first identified in 1969 from cropmarks in aerial photographs. At 8.55 hectares (21.1 acres), it is one of the largest causewayed enclosures in Britain, and would have required thousands of person-days to construct. The cropmarks show an enclosure with two circuits of ditches, and a palisade that ran between the two circuits. There is also evidence of a rectangular structure in the northeastern part of the site, which may be a Neolithic long house or an Anglo-Saxon hall. Excavation in 2019 indicated that the site was constructed in the mid–4th millennium BC. Other finds included oak charcoal fragments believed to come from the palisade, and evidence of a long ditch to the southeast that probably predated the enclosure, and which may have accompanied a long barrow, a form of Neolithic burial mound. The site has been protected as a scheduled monument since 1976. (Full article...)";
//    private long startTime;
//    private Timer timer;
//    private static final int TIME_LIMIT = 5 * 60; // 5 minutes in seconds
//    private int elapsedSeconds = 0;
//
//    public TypingGameSwing() {
//        setTitle("Typing Game with Key Mapping");
//        setSize(600, 500);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//        setLayout(new BorderLayout());
//
//        // Key Mapping Initialization
//        keyMapping = new HashMap<>();
//        initializeKeyMapping();
//
//        // Top Panel for Passage
//        passageArea = new JTextArea(originalPassage);
//        passageArea.setEditable(false);  // Make it uneditable
//        passageArea.setFocusable(false);  // Make it non-focusable
//        passageArea.setFont(new Font("Arial", Font.BOLD, 18));
//        passageArea.setWrapStyleWord(true);
//        passageArea.setLineWrap(true);
//        passageArea.setForeground(new Color(40, 40, 40)); // Dark gray text
//        passageArea.setBackground(new Color(240, 250, 255)); // Soft light blue
//        passageArea.setBorder(BorderFactory.createCompoundBorder(
//                BorderFactory.createLineBorder(new Color(100, 150, 255), 2), // Blue border
//                BorderFactory.createEmptyBorder(15, 15, 15, 15) // Inner padding
//        ));
//
//        // Center Panel for Input
//        inputArea = new JTextArea();
//        inputArea.setFont(new Font("Arial", Font.PLAIN, 16));
//        inputArea.setLineWrap(true);
//        inputArea.setWrapStyleWord(true);
//        inputArea.setEnabled(false);
//        inputArea.setForeground(new Color(40, 40, 40)); // Dark gray text
//        inputArea.setBackground(new Color(255, 245, 230)); // Warm beige
//        inputArea.setBorder(BorderFactory.createCompoundBorder(
//                BorderFactory.createLineBorder(new Color(255, 165, 100), 2), // Soft orange border
//                BorderFactory.createEmptyBorder(15, 15, 15, 15) // Inner padding
//        ));
//
//        JScrollPane inputScrollPane = new JScrollPane(inputArea);
//        inputScrollPane.setBorder(BorderFactory.createTitledBorder(
//                BorderFactory.createLineBorder(new Color(255, 140, 0), 2), // Orange border
//                "Type Here",
//                0, 0, new Font("Arial", Font.BOLD, 14), new Color(255, 140, 0) // Orange title
//        ));
//
//        // Bottom Panel for Buttons and Results
//        JPanel bottomPanel = new JPanel();
//        bottomPanel.setLayout(new GridLayout(2, 1));
//        bottomPanel.setBackground(new Color(230, 240, 250)); // Soft light gray-blue background
//
//        // Timer and Results Panel
//        JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        infoPanel.setBackground(new Color(230, 240, 250)); // Match bottom panel background
//
//        timerLabel = new JLabel("Time: 0:00");
//        timerLabel.setFont(new Font("Arial", Font.BOLD, 16));
//        timerLabel.setForeground(new Color(50, 120, 180)); // Blue text
//
//        resultsLabel = new JLabel(" ");
//        resultsLabel.setFont(new Font("Arial", Font.BOLD, 16));
//        resultsLabel.setForeground(Color.RED); // Default red color for warnings
//
//        infoPanel.add(timerLabel);
//        infoPanel.add(resultsLabel);
//
//        // Buttons Panel
//        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//        buttonsPanel.setBackground(new Color(230, 240, 250)); // Match bottom panel background
//
//        startButton = new JButton("Start Timer");
//        startButton.setFont(new Font("Arial", Font.BOLD, 14));
//        startButton.setBackground(new Color(50, 180, 90)); // Soft green
//        startButton.setForeground(Color.WHITE); // White text
//        startButton.setFocusPainted(false); // Remove focus border
//
//        finishButton = new JButton("Finish Now");
//        finishButton.setFont(new Font("Arial", Font.BOLD, 14));
//        finishButton.setBackground(new Color(230, 60, 60)); // Bright red
//        finishButton.setForeground(Color.WHITE); // White text
//        finishButton.setEnabled(false);
//        finishButton.setFocusPainted(false);
//
//        buttonsPanel.add(startButton);
//        buttonsPanel.add(finishButton);
//
//        bottomPanel.add(infoPanel);
//        bottomPanel.add(buttonsPanel);
//
//        // Adding Panels to Frame
//        add(passageArea, BorderLayout.NORTH);
//        add(inputScrollPane, BorderLayout.CENTER);
//        add(bottomPanel, BorderLayout.SOUTH);
//
//        // Button Actions
//        startButton.addActionListener(e -> startGame());
//        finishButton.addActionListener(e -> finishGame());
//    }
//
//    private void initializeKeyMapping() {
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
//    private void startGame() {
//        inputArea.setText("");
//        inputArea.setEnabled(true);
//        inputArea.requestFocus();
//        startButton.setEnabled(false);
//        finishButton.setEnabled(true);
//        resultsLabel.setText("");
//
//        startTime = System.currentTimeMillis();
//        elapsedSeconds = 0;
//
//        timer = new Timer(1000, e -> updateTimer());
//        timer.start();
//    }
//
//    private void updateTimer() {
//        elapsedSeconds++;
//        int remainingTime = TIME_LIMIT - elapsedSeconds;
//        int minutes = remainingTime / 60;
//        int seconds = remainingTime % 60;
//
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
//
//        inputArea.setEnabled(false);
//        finishButton.setEnabled(false);
//
//        String userInput = inputArea.getText();
//        String decodedInput = decodeInput(userInput);
//        double accuracy = calculateAccuracy(originalPassage, decodedInput);
//
//        long endTime = System.currentTimeMillis();
//        long totalTimeTaken = (endTime - startTime) / 1000; // Time in seconds
//        int minutes = (int) (totalTimeTaken / 60);
//        int seconds = (int) (totalTimeTaken % 60);
//
//        String resultText = String.format("Accuracy: %.2f%%, Time Taken: %d:%02d", accuracy, minutes, seconds);
//        resultsLabel.setText(resultText);
//
//        resultsLabel.setForeground(accuracy > 50 ? Color.GREEN : Color.RED);
//    }
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
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            TypingGameSwing game = new TypingGameSwing();
//            game.setVisible(true);
//        });
//    }
//}
//
//
//
//
////import javax.swing.*;
////import java.awt.*;
////import java.awt.event.*;
////import java.util.HashMap;
////import java.util.Map;
////
////public class TypingGameSwing extends JFrame {
////    private final JTextArea passageArea;
////    private final JTextArea inputArea;
////    private final JLabel timerLabel;
////    private final JLabel resultsLabel;
////    private final JButton startButton;
////    private final JButton finishButton;
////    private final Map<Character, Character> keyMapping;
////
////    private String originalPassage = "The quick brown fox jumps over the lazy dog.";
////    private long startTime;
////    private Timer timer;
////    private static final int TIME_LIMIT = 5 * 60; // 5 minutes in seconds
////    private int elapsedSeconds = 0;
////
////    public TypingGameSwing() {
////        setTitle("Typing Game with Key Mapping");
////        setSize(600, 500);
////        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        setLocationRelativeTo(null);
////        setLayout(new BorderLayout());
////
////        // Key Mapping Initialization
////        keyMapping = new HashMap<>();
////        initializeKeyMapping();
////
////        // Top Panel for Passage
////        passageArea = new JTextArea(originalPassage);
////        passageArea.setEditable(false);  // Make it uneditable
////        passageArea.setFocusable(false);  // Make it non-focusable (so it can't be selected)
////        passageArea.setFont(new Font("Arial", Font.PLAIN, 18));
////        passageArea.setWrapStyleWord(true);
////        passageArea.setLineWrap(true);
////        passageArea.setForeground(Color.BLACK); // Set the text color to black
////        passageArea.setBorder(BorderFactory.createTitledBorder("Passage"));
////
////        // Center Panel for Input
////        inputArea = new JTextArea();
////        inputArea.setFont(new Font("Arial", Font.PLAIN, 16));
////        inputArea.setLineWrap(true);
////        inputArea.setWrapStyleWord(true);
////        inputArea.setEnabled(false);
////        inputArea.addKeyListener(new KeyAdapter() {
////            @Override
////            public void keyTyped(KeyEvent e) {
////                char keyChar = e.getKeyChar();
////                if (keyMapping.containsKey(keyChar)) {
////                    e.consume();
////                    inputArea.append(String.valueOf(keyMapping.get(keyChar)));
////                }
////            }
////        });
////
////        JScrollPane inputScrollPane = new JScrollPane(inputArea);
////        inputScrollPane.setBorder(BorderFactory.createTitledBorder("Type here"));
////
////        // Bottom Panel for Buttons and Results
////        JPanel bottomPanel = new JPanel();
////        bottomPanel.setLayout(new GridLayout(2, 1));
////
////        // Timer and Results Panel
////        JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
////        timerLabel = new JLabel("Time: 0:00");
////        timerLabel.setFont(new Font("Arial", Font.BOLD, 14));
////        resultsLabel = new JLabel(" ");
////        resultsLabel.setFont(new Font("Arial", Font.BOLD, 14));
//////        resultsLabel.setForeground(Color.RED);
////
////        infoPanel.add(timerLabel);
////        infoPanel.add(resultsLabel);
////
////        // Buttons Panel
////        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
////        startButton = new JButton("Start Timer");
////        finishButton = new JButton("Finish Now");
////        finishButton.setEnabled(false);
////
////        buttonsPanel.add(startButton);
////        buttonsPanel.add(finishButton);
////
////        bottomPanel.add(infoPanel);
////        bottomPanel.add(buttonsPanel);
////
////        // Adding Panels to Frame
////        add(passageArea, BorderLayout.NORTH);
////        add(inputScrollPane, BorderLayout.CENTER);
////        add(bottomPanel, BorderLayout.SOUTH);
////
////        // Button Actions
////        startButton.addActionListener(e -> startGame());
////        finishButton.addActionListener(e -> finishGame());
////    }
////
////    private void initializeKeyMapping() {
////        keyMapping.put('a', 'g'); keyMapping.put('b', 'k'); keyMapping.put('c', 'm');
////        keyMapping.put('d', 'r'); keyMapping.put('e', 't'); keyMapping.put('f', 'z');
////        keyMapping.put('g', 'a'); keyMapping.put('h', 'o'); keyMapping.put('i', 'e');
////        keyMapping.put('j', 'y'); keyMapping.put('k', 'b'); keyMapping.put('l', 'u');
////        keyMapping.put('m', 'c'); keyMapping.put('n', 'd'); keyMapping.put('o', 'h');
////        keyMapping.put('p', 'x'); keyMapping.put('q', 'w'); keyMapping.put('r', 'f');
////        keyMapping.put('s', 'l'); keyMapping.put('t', 'n'); keyMapping.put('u', 'p');
////        keyMapping.put('v', 'q'); keyMapping.put('w', 'v'); keyMapping.put('x', 'j');
////        keyMapping.put('y', 's'); keyMapping.put('z', 'i'); keyMapping.put(' ', ' ');
////    }
////
////    private void startGame() {
////        inputArea.setText("");
////        inputArea.setEnabled(true);
////        inputArea.requestFocus();
////        startButton.setEnabled(false);
////        finishButton.setEnabled(true);
////        resultsLabel.setText("");
////
////        startTime = System.currentTimeMillis();
////        elapsedSeconds = 0;
////
////        timer = new Timer(1000, e -> updateTimer());
////        timer.start();
////    }
////
////    private void updateTimer() {
////        elapsedSeconds++;
////        int remainingTime = TIME_LIMIT - elapsedSeconds;
////        int minutes = remainingTime / 60;
////        int seconds = remainingTime % 60;
////
////        timerLabel.setText(String.format("Time: %d:%02d", minutes, seconds));
////
////        if (remainingTime <= 0) {
////            timer.stop();
////            finishGame();
////            JOptionPane.showMessageDialog(this, "Time's up!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
////        }
////    }
////
////    private void finishGame() {
////        if (timer != null) timer.stop();
////
////        inputArea.setEnabled(false);
////        finishButton.setEnabled(false);
////
////        String userInput = inputArea.getText();
////        String decodedInput = decodeInput(userInput);
////        double accuracy = calculateAccuracy(originalPassage, decodedInput);
////
////        long endTime = System.currentTimeMillis();
////        long totalTimeTaken = (endTime - startTime) / 1000; // Time in seconds
////        int minutes = (int) (totalTimeTaken / 60);
////        int seconds = (int) (totalTimeTaken % 60);
////
////        // Set result text with accuracy and time
////        String resultText = String.format("Accuracy: %.2f%%, Time Taken: %d:%02d", accuracy, minutes, seconds);
////        resultsLabel.setText(resultText);
////
////        // Change font color based on accuracy
////        if (accuracy > 50) {
////            resultsLabel.setForeground(Color.GREEN);
////        } else {
////            resultsLabel.setForeground(Color.RED);
////        }
////    }
////
////
////    private String decodeInput(String input) {
////        StringBuilder decoded = new StringBuilder();
////        for (char c : input.toCharArray()) {
////            decoded.append(keyMapping.entrySet().stream()
////                    .filter(entry -> entry.getValue() == c)
////                    .map(Map.Entry::getKey)
////                    .findFirst()
////                    .orElse(c));
////        }
////        return decoded.toString();
////    }
////
////    private double calculateAccuracy(String original, String typed) {
////        int correct = 0;
////        for (int i = 0; i < Math.min(original.length(), typed.length()); i++) {
////            if (original.charAt(i) == typed.charAt(i)) correct++;
////        }
////        return ((double) correct / original.length()) * 100;
////
////    }
////
////    public static void main(String[] args) {
////        SwingUtilities.invokeLater(() -> {
////            TypingGameSwing game = new TypingGameSwing();
////            game.setVisible(true);
////        });
////    }
////}
//
//
//
