package AdavanceJava.loginDB;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class forgot extends Frame implements ActionListener {

    Label name = new Label("Enter User Name");
    Label pass = new Label("Enter New Password");
    Label message = new Label("Message");
    Button change = new Button("Change Password");
//    Button login = new Button("Go To Loin Page");
    TextField username = new TextField();
    TextField password = new TextField();
    TextField successMsg = new TextField();

    forgot(){
        name.setBounds(100,80,100,20);  //label
        pass.setBounds(100,150,150,20); //label
        username.setBounds(250,80,190,20); //text
        password.setBounds(250,150,190,20); //text
//        login.setBounds(250, 200, 100, 30);
        change.setBounds(180, 200, 150, 30);
        message.setBounds(100, 250, 100, 20);
        successMsg.setBounds(100, 300, 290, 20);

        add(name);
        add(pass);
        add(username);
        add(password);
        add(successMsg);
        add(change);
//        add(login);
        add(message);

        change.addActionListener(this);
//        login.addActionListener(this);

        setSize(700,700);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == change){
            if(username.getText().isEmpty() && password.getText().isEmpty()){
                successMsg.setText("Please enter username and password");
            } else if(username.getText().isEmpty()){
                successMsg.setText("Please enter username");
            } else if(password.getText().isEmpty()){
                successMsg.setText("Please enter password");
            }
            else {
                changePass();
            }
        }

    }

    public void changePass() {
        String id = username.getText();
        String pass = password.getText();
        try {
            // Driver Load
            Class.forName("org.postgresql.Driver");
            //Connection
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/login", "postgres", "root@123");
            //statement creation
            Statement stmt = con.createStatement();
            String query = "update credentials set password = '" + pass + "' where id = '" + id + "'";
            stmt.executeUpdate(query);
            successMsg.setText("Password Changed Successfully");
            System.out.println("Password Changed Successfully");
            con.close();
        } catch (Exception er) {
            System.out.println(er);
        }
    }
//    public static void main(String[] args) {
//        forgot f = new forgot();
//    }
}
