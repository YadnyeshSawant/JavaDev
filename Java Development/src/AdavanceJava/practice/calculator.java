package AdavanceJava.practice;
import FinalKeyword.A;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
//import java.lang.classfile.ClassBuilder;

public class calculator extends Frame implements ActionListener {
    Label in1 = new Label("Enter the fist number");
    Label in2 = new Label("Enter the second number");
    TextField input1 = new TextField();
    TextField input2 = new TextField();
    TextField output = new TextField();
    TextField equal =  new TextField("=");
    Button add = new Button("+");
    Button sub = new Button("-");
    Button mul = new Button("*");
    Button divide = new Button("/");

    calculator(){
        in1.setBounds(10,60,200,10);
        input1.setBounds(10,80,20,20);
        input2.setBounds(40, 80, 20, 20);
        equal.setBounds(70,80, 20, 20);
        output.setBounds(95,80,20,20);

        add.setBounds(10,105,20,30);
        sub.setBounds(40,105,20,30);

        mul.setBounds(10,140,20,30);
        divide.setBounds(40,140,20,30);

        add(in1);
        add(input1);
        add(in2);
        add(input2);
        add(equal);
        add(output);
        add(add);
        add(sub);
        add(mul);
        add(divide);

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        divide.addActionListener(this);

        setSize(500,500);
        setLayout(null);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e){
        int a = Integer.parseInt(input1.getText());
        int b = Integer.parseInt(input2.getText());
        int c = 0;
        if(e.getSource() == add){
            c = a+b;
        }
        if(e.getSource() == sub){
            c = a-b;
        }
        if(e.getSource() == mul){
            c = a*b;
        }
        if(e.getSource() == divide){
            c = a/b;
        }
        String result = String.valueOf(c);
        output.setText(result);
    }

    public static void main(String[] args) {
        calculator c = new calculator();
    }
}
