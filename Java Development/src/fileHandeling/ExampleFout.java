package fileHandeling;
import java.io.FileOutputStream;
public class ExampleFout {
	public static void main(String[] args) {
		try {
			FileOutputStream f1 = new FileOutputStream("D:\\JavaDev\\Java Development\\src\\fileHandeling\\Test.txt");
			f1.write(65); // for single character input
			f1.close();
			System.out.println("Success");
		} catch (Exception e) {System.out.println(e);}
		try {
			FileOutputStream f2 = new FileOutputStream("D:\\JavaDev\\Java Development\\src\\fileHandeling\\Test1.txt");
			String s = "Wlecome to java"; 
			byte b[] = s.getBytes();
			f2.write(b);
			f2.close();
		} catch (Exception e) {
			System.out.println();
		}
	}
}
