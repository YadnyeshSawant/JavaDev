package fileHandeling;
import java.io.FileInputStream;
public class ExampleFin {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			FileInputStream f1 = new FileInputStream("D:\\JavaDev\\Java Development\\src\\fileHandeling\\Test.txt");
			int i =f1.read();    // read only a single character
			System.out.println((char)i); 
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			FileInputStream f1 = new FileInputStream("D:\\JavaDev\\Java Development\\src\\fileHandeling\\Test1.txt");
			int i =0;
			while((i=f1.read())!= -1)   //read multiple lines until the EOF (End of File)
			{
				System.out.print((char)i);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
