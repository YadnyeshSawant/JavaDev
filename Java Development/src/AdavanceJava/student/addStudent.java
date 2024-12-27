package AdavanceJava.student;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.ResultSet;


public class addStudent extends Frame implements ActionListener {
    Label title =  new Label("Add Student");
    Label roll = new Label("Roll No");
    Label name = new Label("Name");
    Label phoneno = new Label("Phone No");
    Label cla = new Label("class");
    TextField rno = new TextField();
    TextField sname = new TextField();
    TextField phone = new TextField();
    TextField clas = new TextField();
    Button addStudent = new Button("Add Student ");
    Button backToCheck = new Button("Back To Check");
    Button clear = new Button("clear");
    TextField msg = new TextField();

    addStudent(){
        title.setBounds(150,50,100,20);
        roll.setBounds(100,100,40,20); //label
        name.setBounds(100, 130, 40, 20); //label
        phoneno.setBounds(100, 160, 60, 20); //label
        cla.setBounds(100, 190, 40, 20); //label
        rno.setBounds(160, 100, 150, 20); //text
        sname.setBounds(160, 130, 150, 20); //text
        phone.setBounds(160, 160, 150, 20); //text
        clas.setBounds(160, 190, 150, 20);//text
        backToCheck.setBounds(100, 340, 100, 25); //button
        addStudent.setBounds(210, 340, 100, 25); //button
        msg.setBounds(100, 270, 210, 20);
        clear.setBounds(320, 340, 100, 25); //button
        add(title);
        add(roll);
        add(name);
        add(phoneno);
        add(cla);
        add(rno);
        add(sname);
        add(phone);
        add(clas);
        add(backToCheck);
        add(addStudent);
        add(msg);
        add(clear);

        backToCheck.addActionListener(this);
        addStudent.addActionListener(this);
        clear.addActionListener(this);

        setSize(500, 500);
        setLayout(null);
        setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backToCheck){
            infodisplay id = new infodisplay();
        }
        if(e.getSource() ==addStudent){
            if(rno.getText().isEmpty() || sname.getText().isEmpty() || phone.getText().isEmpty() || clas.getText().isEmpty()) {
                msg.setText("Please enter details");
            }
            else{
                addStud();
            }
        }
        if(e.getSource()==clear){
            rno.setText("");
            sname.setText("");
            phone.setText("");
            clas.setText("");
            msg.setText("");
        }
    }

    private void addStud() {
        int r = Integer.parseInt(rno.getText());
        String sn = sname.getText();
        String pno = phone.getText();
        String cl = clas.getText();
        try{
            // Driver Load
            Class.forName("org.postgresql.Driver");
            //Connection
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student", "postgres", "root@123");

            //statement creation
            PreparedStatement pstmt = con.prepareStatement("select * from info where rollno = ?");
            pstmt.setInt(1, r);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                msg.setText("Roll No already exists");
            }
            else {
                PreparedStatement pst = con.prepareStatement("insert into info values(?,?,?,?)");
                pst.setInt(1,r);
                pst.setString(2,sn);
                pst.setString(3,pno);
                pst.setString(4,cl);
                int i = pst.executeUpdate();
                msg.setText(i+"Record inserted");
            }
            con.close();

        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        addStudent ads = new addStudent();
    }
}
