package AdavanceJava.practice;
import java.awt.event.ActionListener;
import java.awt.*;

public class DisplayName extends Frame implements ActionListener {
    TextField t = new TextField();
    TextField output = new TextField();
    Button print = new Button("Print");
    Button clear = new Button("Clear");
    DisplayName(){

        t.setBounds(10,60,150,20);
        output.setBounds(10,130,150,20);
        print.setBounds(10,90,70,30);
        clear.setBounds(90,90,70,30);

        add(t);
        add(print);
        add(clear);
        add(output);

        print.addActionListener(this);
        clear.addActionListener(this);

        setSize(300,300);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() == print) {
            output.setText("Hello " + t.getText());
            System.out.println(t.getText());
        }
        if (e.getSource() == clear) {
            t.setText("");
            output.setText("");
        }
    }
    public static void main(String[] args) {
        DisplayName d = new DisplayName();
    }
}
