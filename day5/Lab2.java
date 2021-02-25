package day5;

/**
 * import java.awt.*; package Mypackage; class Myclass {} // error : package
 * name should in first line package MyPackage import java.awt.*; class
 * MyClass{} // It will work fine "comments " package MyPackage; import
 * java.awt.*; class MyClass{} // IT will work fine
 */
/**
 * variable name can be like variable2, _1_ and can starts with _$# should not
 * start with number, it can be in between or at the end
 */
public class Lab2 {
	static int then;// then is not reserved word in java

	public static void main(String arguments[]) {
		// float f = 1.3;// float f = 1.3f;
		char c = 'a';
		int i = 10;
		// boolean b = null;//boolean b = true;
		// byte by = 257;//byte by = (byte) 257 and size of a byte is from -128 to 127

		int anar[] = new int[] { 1, 2, 3 };
		System.out.println(anar[1]); // array starts from 0 so it will print 2

		int anar2[] = new int[5];
		System.out.println(anar2[0]); // It will print 0

		amethod(arguments);
		System.out.println(then);// it will give zero

		switch (i) { // it will print one, two, default since no break statement
		default:
			System.out.println("default"); // It will execute default since i=10 and no matching case it will print rest
											// untill find break statement
		case 0:
			System.out.println("zero");
			break;
		case 1:
			System.out.println("one");

		case 2:
			System.out.println("two");

		}

//		i = 0;
//		if (i) {
//			System.out.println("Hello"); // not boolean
//		}
		boolean b = true;
		boolean b2 = true;
		if (b == b2) {
			System.out.println("So true");
		}
		int k = 1;
		int j = 2;
		if (k == 1 || j == 2)
			System.out.println("OK");

//		int m=1;  
//		int n=2;  
//		if(m==1 &| n==2)  // Systax error only && || permitted        
//			System.out.println("OK"); 
	}

	public static void amethod(String[] arguments) {// error Can't make static reference to void amethod.
		// System.out.println(arguments);
		// System.out.println(arguments[2]); // Exception raised:
		// "java.lang.ArrayIndexOutOfBoundsException: 2 since we
		// pass only one argument, It should be accessed as argv[0]"

		/***
		 * No such file found, Doing finally, -1 finally will execute definitely try {
		 * FileInputStream dis=new FileInputStream("Hello.txt"); }catch
		 * (FileNotFoundException fne) { System.out.println("No such file found");
		 * return -1; }catch(IOException ioe) { } finally{ System.out.println("Doing
		 * finally"); } return 0; }
		 */

	}
}

/**
 * abstract class MineBase { //Error Mine must be declared abstract // abstract
 * void amethod(); // // static int i; //} // //class Mine extends MineBase { //
 * public static void main(String argv[]) { // int[] ar = new int[5]; // for (i
 * = 0; i < ar.length; i++) // System.out.println(ar[i]); // } }
 */

// No support for Applets in jvm 15