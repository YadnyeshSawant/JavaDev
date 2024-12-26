package AdavanceJava.practice;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class infromation extends Frame implements ActionListener {
    Label BasicInfo = new Label("Basic Information");
    Label FirstName = new Label("First Name");
    Label MiddleName = new Label("Middle Name");
    Label LastName = new Label("Last Name");
    Label Date_Of_Birth = new Label("Date Of Birth");
    Label Gender = new Label("Gender");
    Label Address = new Label("Address");
    Label City = new Label("City");
    Label State = new Label("State");
    Label ZipCode = new Label("Zip Code");
    Label Contact = new Label("Contact Number");
    Label Email = new Label("Email");
    TextField fname = new TextField();
    TextField mname = new TextField();
    TextField lname = new TextField();
    TextField dob = new TextField();
    TextField gender = new TextField();
    TextField address = new TextField();
    TextField city = new TextField();
    TextField state = new TextField();
    TextField zipcode = new TextField();
    TextField contact = new TextField("+91 ");
    TextField email = new TextField();
    Button save = new Button("Save");


    infromation(){
        //set Bounds
        FirstName.setBounds(40, 100,80, 20);
        fname.setBounds(130,100,150,20);
        MiddleName.setBounds(300,100,80,20);
        mname.setBounds(390,100,150,20);
        LastName.setBounds(40, 140,80, 20);
        lname.setBounds(130,140,150,20);
        Date_Of_Birth.setBounds(300, 140, 80, 20);
        dob.setBounds(390, 140, 150, 20);
        Address.setBounds(40, 180, 80, 20);
        address.setBounds(130,180,405,20);
        City.setBounds(40, 220, 80, 20);
        city.setBounds(130, 220, 150, 20);
        State.setBounds(300, 220, 80, 20);
        state.setBounds(390, 220, 150, 20);
        ZipCode.setBounds(40, 260, 80, 20);
        zipcode.setBounds(130, 260, 150, 20);
        Contact.setBounds(300, 260, 90, 20);
        contact.setBounds(390, 260, 150, 20);






        //add contents to frame
        add(FirstName);
        add(fname);
        add(MiddleName);
        add(mname);
        add(LastName);
        add(lname);
        add(Date_Of_Birth);
        add(dob);
        add(Gender);
        add(gender);
        add(Address);
        add(address);
        add(City);
        add(city);
        add(State);
        add(state);
        add(ZipCode);
        add(zipcode);
        add(Contact);
        add(contact);
        add(Email);
        add(email);
        add(save);



        //action register
        save.addActionListener(this);

        //set frame layout, size, visibility
        setSize(800,800);
        setLayout(null);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e){

    }
    public static void main(String[] args) {
        infromation info = new infromation();

    }
}
