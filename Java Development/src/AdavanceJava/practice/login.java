package AdavanceJava.practice;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login extends Frame implements ActionListener {
    Label name = new Label("Enter User Name");
    Label pass = new Label("Enter Password");
    Button login = new Button("Login");
    Button clear = new Button("Clear");
    TextField username = new TextField();
    TextField password = new TextField();
    TextField successMsg = new TextField();

    login(){
        name.setBounds(100,80,100,20);
        username.setBounds(200,80,190,20);
        pass.setBounds(100,150,100,20);
        password.setBounds(200,150,190,20);
        login.setBounds(150,200,50,30);
        clear.setBounds(250,200,50,30);
        successMsg.setBounds(100, 250, 290, 20);

        add(name);
        add(pass);
        add(username);
        add(password);
        add(login);
        add(clear);
        add(successMsg);

        login.addActionListener(this);
        clear.addActionListener(this);

        setSize(700,700);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String originalUser = "admin";
        int originalPassword = 1234;

        String userInput = username.getText();
        int userInputPassword = Integer.parseInt(password.getText());

        if(e.getSource() == login && originalPassword == userInputPassword && userInput.equals(originalUser)) {
            successMsg.setText("Login Successful");
            System.out.println("Login success");

        }
        else if (e.getSource() == login && originalPassword != userInputPassword && userInput.equals(originalUser)) {
            successMsg.setText("Password Incorrect");
            System.out.println("Password Incorrect");

        }
        else if (e.getSource() == login && originalPassword == userInputPassword && !userInput.equals(originalUser)) {
            successMsg.setText("Username Incorrect");
            System.out.println("Username Incorrect");

        }
        if(e.getSource() == clear){
            username.setText("");
            password.setText("");
            successMsg.setText("Cleared Success");
            successMsg.setText("");
        }
    }

    public static void main(String[] args) {
        login l = new login();
    }
}
