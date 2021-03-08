package day15;

import java.io.File;

public class IODemo2 {
	public static void main(String[] args) {
		File file = new File("");
		System.out.println("path  : "+file.getAbsolutePath() );
		System.out.println("name :"+file.getName());
		System.out.println(file.exists() ? "yes":"No");
		System.out.println(file.canWrite());
		System.out.println(file.canRead());
		System.out.println(file.canExecute());
		System.out.println(file.isDirectory());
		
	}
}
