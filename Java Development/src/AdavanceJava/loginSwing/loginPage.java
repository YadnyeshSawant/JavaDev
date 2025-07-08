package AdavanceJava.loginSwing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class loginPage implements ActionListener {
    JFrame f = new JFrame();
    JButton login = new JButton("LOGIN");
    JLabel userid = new JLabel("User Id");
    JLabel password = new JLabel("Password");
    JTextField id = new JTextField();
    JTextField pass= new JTextField();
    JTextField mess= new JTextField();



    loginPage(){
        userid.setBounds(10, 30, 100, 20);
        password.setBounds(10, 55, 100, 20);
        id.setBounds(120, 30, 200, 20);
        pass.setBounds(120,55,200,20);
        login.setBounds(90,90,100,25);
        mess.setBounds(10,120,300,20);



        f.add(userid);
        f.add(password);
        f.add(id);
        f.add(pass);
        f.add(login);
        f.add(mess);

        login.addActionListener(this);

        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            String uid = id.getText();
            String pwd = pass.getText();
            if (e.getSource() == login) {
                if (id.getText().isEmpty() && pass.getText().isEmpty()) {
                    mess.setText("Please enter username and password");
                } else if (id.getText().isEmpty()) {
                    mess.setText("Please enter username");
                } else if (pass.getText().isEmpty()) {
                    mess.setText("Please enter password");
                } else {
                    tryLogin();
                }

            }
        }
    }
        private void tryLogin () {
            try {

                //driver load
                Class.forName("org.postgresql.Driver");
                //connection
                Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/login", "postgres", "root@123");
                //statement creation
                Statement stmt = con.createStatement();
                String query = "Select * from credentials";
                ResultSet rs = stmt.executeQuery(query);
                if (rs.next()) {
                    mess.setText("Login Success");
                    System.out.println("Login Success");
                } else {
                    mess.setText("Invalid Credentials");
                    System.out.println("Login Failed");
                }
            }catch (Exception e) {
                System.out.println(e);
            }
        }
        public static void main (String[] args){
            loginPage lp = new loginPage();
        }
}

