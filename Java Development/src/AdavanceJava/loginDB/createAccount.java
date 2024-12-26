package AdavanceJava.loginDB;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class createAccount extends Frame implements ActionListener {
    Label name = new Label("Enter User Name");
    Label pass = new Label("Enter Password");
    Label message = new Label("Message");
    Button create = new Button("Create Account");
    Button login = new Button("Go To Loin Page");
    TextField username = new TextField();
    TextField password = new TextField();
    TextField successMsg = new TextField();

    createAccount(){
        name.setBounds(100,80,100,20);
        username.setBounds(200,80,190,20);
        pass.setBounds(100,150,100,20);
        password.setBounds(200,150,190,20);
        login.setBounds(250, 200, 100, 30);
        create.setBounds(100, 200, 100, 30);
        message.setBounds(100, 250, 100, 20);
        successMsg.setBounds(100, 300, 290, 20);

        add(name);
        add(pass);
        add(username);
        add(password);
        add(successMsg);
        add(create);
        add(login);
        add(message);


        create.addActionListener(this);
        login.addActionListener(this);

        setSize(700,700);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == create){
            if(username.getText().isEmpty() && password.getText().isEmpty()){
                successMsg.setText("Please enter username and password");
            } else if(username.getText().isEmpty()){
                successMsg.setText("Please enter username");
            } else if(password.getText().isEmpty()){
                successMsg.setText("Please enter password");
            }
            else {
                creatAcc();
            }
        }
        if(e.getSource() == login){
            Dblogin db = new Dblogin();
        }
    }

    void creatAcc() {
        String id = username.getText();
        String pass = password.getText();
        try {
            // Driver Load
            Class.forName("org.postgresql.Driver");
            //Connection
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/login", "postgres", "root@123");
            //statement creation
            Statement stmt = con.createStatement();
            String query = "insert into credentials values('" + id + "','" + pass + "')";
            stmt.executeUpdate(query);
            successMsg.setText("Account Created Successfully");
            System.out.println("Account Created Successfully");
            con.close();
        } catch (Exception er) {
            System.out.println(er);
        }
    }
//    public static void main(String[] args) {
//        createAccount ca = new createAccount();
//    }
}
