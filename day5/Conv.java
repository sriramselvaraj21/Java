package day5;

// How can you change the current working directory using an instance of the File class called FileName?  
// The File class does not support directly changing the current directory.
public class Conv {
	public static void main(String argv[]) {
		Conv c = new Conv();
		String s = new String("ello");
		c.amethod(s);

		String s1 = "Java";
		String s2 = "java";
		if (s1.equalsIgnoreCase(s2)) {
			System.out.println("Equal");
		} else {

			System.out.println("Not equal");
		}
	}

	public void amethod(String s) {
		char c = 'H';
		// c += s; // Compile time error | The operator += is undefined for the argument
		// type(s) char, String
		System.out.println(c);
	}
}