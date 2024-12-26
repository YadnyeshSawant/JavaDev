package fileHandeling;
import java.io.*;
public class ExampleBout {
	public static void main(String[] args) {
		try {
			FileOutputStream f1 = new FileOutputStream("D:\\JavaDev\\Java Development\\src\\fileHandeling\\TestBout.txt");
			BufferedOutputStream bout = new BufferedOutputStream(f1);
			String s = "Statement using Buffer";
			byte b[] = s.getBytes();
			bout.write(b);
			bout.flush();
			bout.close();
			f1.close();
			System.out.println("Success");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
