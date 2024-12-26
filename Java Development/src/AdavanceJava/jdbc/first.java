package AdavanceJava.jdbc;
import java.sql.*;
class first{
    public static void main(String[] args){
        try{
            // Driver Load
            Class.forName("org.postgresql.Driver");
            //Connection  
            Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/javadev","postgres","root@123");
            //statement creation
            Statement stmt=con.createStatement();
            //statement execution
            stmt.executeUpdate("update info set name ='Raj' where no=1");
            ResultSet rs=stmt.executeQuery("select * from info order by no");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
