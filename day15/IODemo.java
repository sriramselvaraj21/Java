package day15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class IODemo {
	public static void main(String[] args) {
		CopyCommand cc = new CopyCommand();
		cc.copy("abc.txt");
	}
}

class CopyCommand {
	public void copy(String filename) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		FileReader fr = null;

		try (FileWriter fw = new FileWriter("abc.txt")) {
			fr = new FileReader(filename);
			int noOfCharRead;
			char c[] = new char[8];
			while ((noOfCharRead = fr.read(c)) != -1) {
				String s = new String(c, 0, noOfCharRead);
				System.out.println(s);
				fw.write(c, 0, noOfCharRead);
			}

		} catch (Exception e) {
		}

	}
}