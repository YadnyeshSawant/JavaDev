package AdavanceJava.student;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class infodisplay extends Frame implements ActionListener {
    Label title =  new Label("Check Student");
    Label roll = new Label("Roll No");
    Label name = new Label("Name");
    Label phoneno = new Label("Phone No");
    Label cla = new Label("Class");
    TextField rno = new TextField();
    TextField sname = new TextField();
    TextField phone = new TextField();
    TextField clas = new TextField();
    Button check = new Button("Check Student");
    Button addStudent = new Button("Add Student ");
    TextField msg = new TextField();
    infodisplay(){
        title.setBounds(150,50,100,20);
        roll.setBounds(100,100,40,20); //label
        name.setBounds(100, 130, 40, 20); //label
        phoneno.setBounds(100, 160, 60, 20); //label
        cla.setBounds(100, 190, 40, 20); //label
        rno.setBounds(160, 100, 150, 20); //text
        sname.setBounds(160, 130, 150, 20); //text
        phone.setBounds(160, 160, 150, 20); //text
        clas.setBounds(160, 190, 150, 20);//text
        check.setBounds(100, 240, 100, 25); //button
        addStudent.setBounds(210, 240, 100, 25); //button
        msg.setBounds(100, 270, 210, 20);
        add(title);
        add(roll);
        add(name);
        add(phoneno);
        add(cla);
        add(rno);
        add(sname);
        add(phone);
        add(clas);
        add(check);
        add(addStudent);
        add(msg);


        check.addActionListener(this);
        addStudent.addActionListener(this);

        setSize(500, 500);
        setLayout(null);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==check){
            checkStud();

        }
        if(e.getSource()==addStudent){
            addStudent as = new addStudent();
        }
    }

    private void checkStud() {
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
            PreparedStatement pst = con.prepareStatement("select * from info where rollno = ?");
            pst.setInt(1,r);

            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                msg.setText("Result Found");
            }
            con.close();

        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        infodisplay id = new infodisplay();
    }
}
