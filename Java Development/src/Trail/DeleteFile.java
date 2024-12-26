package Trail;
import java.io.File;  // Import the File class

public class DeleteFile {
    public static void main(String[] args) {
        try {

            String name = args[0];
            File myObj = new File(name);
            if (myObj.delete()) {
                System.out.println("Deleted the file: " + myObj.getName());
            } else {
                System.out.println("Failed to delete the file.");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}