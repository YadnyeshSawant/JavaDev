package AdavanceJava.loginDB;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dblogin extends Frame implements ActionListener{
    Label name = new Label("Enter User Name");
    Label pass = new Label("Enter Password");
    Button login = new Button("Login");
    Button clear = new Button("Clear");
    Button create = new Button("Create Account");
    Button change = new Button("Forgot Password");
    TextField username = new TextField();
    TextField password = new TextField();
    TextField successMsg = new TextField();

    Dblogin(){
        name.setBounds(100,80,100,20);
        username.setBounds(200,80,240,20);
        pass.setBounds(100,150,100,20);
        password.setBounds(200,150,240,20);
        login.setBounds(150,200,50,30);
        clear.setBounds(250,200,50,30);
        successMsg.setBounds(100, 250, 340, 20);
        create.setBounds(100, 300, 150, 30);
        change.setBounds(300, 300, 150, 30);

        add(name);
        add(pass);
        add(username);
        add(password);
        add(login);
        add(clear);
        add(successMsg);
        add(create);
        add(change);

        login.addActionListener(this);
        clear.addActionListener(this);
        create.addActionListener(this);
        change.addActionListener(this);

        setSize(700,700);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login) {
            if(username.getText().isEmpty() && password.getText().isEmpty()){
                successMsg.setText("Please enter username and password");
            } else if(username.getText().isEmpty()){
                successMsg.setText("Please enter username");
            } else if(password.getText().isEmpty()){
                successMsg.setText("Please enter password");
            }
            else{
                tryLogin();
            }
        }
        if(e.getSource() == clear){
            username.setText("");
            password.setText("");
            successMsg.setText("Cleared Success");
            successMsg.setText("");
        }
        if(e.getSource() == create){
                createAccount ca = new createAccount();
        }
        if(e.getSource() == change){
            forgot f = new forgot();
        }
    }
    void tryLogin(){
        String id = username.getText();
        String pass = password.getText();
        try {
            // Driver Load
            Class.forName("org.postgresql.Driver");
            //Connection
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/login", "postgres", "root@123");
            //statement creation
            Statement stmt = con.createStatement();

            String query = "select * from credentials where id = '" + id + "' and password = '" + pass + "'";

            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()){
                successMsg.setText("Login Success");
                System.out.println("Login Success");
                System.out.println(rs.getString(1)+"  "+rs.getString(2));

            } else {
                successMsg.setText("Invalid Credentials");
                System.out.println("Login Failed");
            }
            con.close();
        } catch (Exception er) {
            System.out.println(er);
        }
    }
//    public static void main(String[] args) {
//        Dblogin db = new Dblogin();
//    }
}
