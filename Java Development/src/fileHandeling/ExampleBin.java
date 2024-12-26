package fileHandeling;
import java.io.*;
public class ExampleBin {
	public static void main(String[] args) {
		try {
			FileInputStream f1 = new FileInputStream("D:\\JavaDev\\Java Development\\src\\fileHandeling\\TestBout.txt");
			@SuppressWarnings("resource")
			BufferedInputStream bin = new BufferedInputStream(f1);
			int i = 0;
			while((i=bin.read())!=-1) {
				System.out.print((char)i);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
