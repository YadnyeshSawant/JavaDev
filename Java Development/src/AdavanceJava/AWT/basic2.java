package AdavanceJava.AWT;
//Program to create the window using association
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.Frame;

public class basic2 {

    basic2(){
        // create a object of the frame class
        Frame f = new Frame("Basic 2 using Assocication");
        // Create components

        Button b1 = new Button("Button 1");
        Button b2 = new Button("Button 2");

        b1.setBounds(20,30,70,40);
        b2.setBounds(40,80,70,40);

        //add components to the frame
        f.add(b1);
        f.add(b2);

        // set the size, layout and visibility of the frame
        f.setSize(500,300);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        basic2 b = new basic2();
    }
}
