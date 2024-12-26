package Trail;
import java.io.*;
import java.io.BufferedWriter;

public class ques {
    public static void main(String[] args){
        try{
                FileReader r = new FileReader("D:\\JavaDev\\Java Development\\src\\Trail\\file1");
                BufferedReader bfr = new BufferedReader(r);

                FileWriter w = new FileWriter("D:\\JavaDev\\Java Development\\src\\Trail\\file2");
                BufferedWriter bfw = new BufferedWriter(w);
                int i;
                while((i=bfr.read())!=-1){
                    bfw.write((char) i);
                }
                bfr.close();
                bfw.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
