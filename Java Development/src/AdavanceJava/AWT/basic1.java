package AdavanceJava.AWT;
// Program to create a window using interface of the Frame class
import java.awt.*;
public class basic1 extends Frame{
    basic1(){

        // create the component
        Button b1 = new Button("Button 1");
        Button b2 = new Button("Button 2");

        //set the bounds or the location of the component
        b1.setBounds(300,200,50,40);
        b2.setBounds(700,700,50,50);

        // add components to the frame
        add(b1);
        add(b2);

        //set frame size, layout, visibility
        setSize(300,300);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        basic1 b = new basic1();
    }
}
