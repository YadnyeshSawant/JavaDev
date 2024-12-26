package AdavanceJava.AWT;
import java.awt.*;
import java.awt.Frame;
import java.awt.event.*;

class event1 extends Frame implements ActionListener{
    Button b1 = new Button("Button");
    event1(){
        b1.setBounds(20,30,50,60);

        add(b1);
        setSize(300,300);
        setLayout(null);
        setVisible(true);

        //register listener
        b1.addActionListener(this);

    }
    public void actionPerformed(ActionEvent e){
        b1.setLabel("Button Clicked");
    }
    public static void main(String[] args) {
        new event1();
    }
}
