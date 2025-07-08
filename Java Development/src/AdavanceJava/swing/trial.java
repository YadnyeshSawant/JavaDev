package AdavanceJava.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class trial implements ActionListener{
    JFrame f = new JFrame();
    JButton btn = new JButton();
    JButton submit = new JButton();
    JTextField iptxt = new JTextField();
    JTextField optxt = new JTextField();
    trial() {
        btn.setBounds(100, 100, 100, 100);
        btn.setText("Click me");
        iptxt.setBounds(10, 30, 300, 20);
        optxt.setBounds(10, 55, 300, 20);
        submit.setBounds(10, 80, 100, 20);
        submit.setText("Submit");
        f.add(iptxt);
        f.add(optxt);
        f.add(submit);

        //event
        submit.addActionListener(this);

        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit) {
            String s1 = iptxt.getText();
            optxt.setText(s1+" Sawant");
        }
    }
    public static void main(String[] args) {
        trial t = new trial();
    }
}

// create the elements
// set size of elements
// event listener is needed
// override actionPerformed method