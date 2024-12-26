package AdavanceJava.swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

public class calculator extends Frame implements ActionListener, EventListener {
    Label l1 = new Label("Enter number :");
    Label l2 = new Label("Enter number :");
    TextField t1 = new TextField();
    TextField t2 = new TextField();
    Button add = new Button("+");
    Button sub = new Button("-");
    Button mul = new Button("*");
    Button div = new Button("/");
    TextField output =new TextField();
    calculator(){
        //
        l1.setBounds(20,50,75,20);
        t1.setBounds(100,50,50,20);
        l2.setBounds(20,80,75,20);
        t2.setBounds(100,80,50,20);
        add.setBounds(20,110,50,20);
        sub.setBounds(90,110,50,20);
        mul.setBounds(20,150,50,20);
        div.setBounds(90,150,50,20);
        output.setBounds(50,190,50,20);
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(add);
        add(sub);
        add(mul);
        add(div);
        add(output);
        //output.setEditable(false);

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);

        setSize(400,500);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s1 = t1.getText();
        String s2 = t2.getText();
        int n1 = Integer.parseInt(s1);
        int n2 = Integer.parseInt(s2);
        int ans = 0;
        if (e.getSource() == add){
            ans = n1 + n2;
        }
        if (e.getSource()==sub){
            ans= n1-n2;
        }
        if (e.getSource()==mul){
            ans = n1 * n2;
        }
        if (e.getSource()==div){
            ans = n1/n2;
        }
        String answer = String.valueOf(ans);
        output.setText(answer);

    }

    public static void main(String[] args) {
        calculator c1 = new calculator();
    }
}