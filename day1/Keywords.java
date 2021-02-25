package day1;

public class Keywords {
	static int a = 21; // final cannot be modified

	public Keywords(int n) {
		System.out.println(n);
	}

	public static void main(String[] args) {
		System.out.println("To access static members in non static method, we need to create object and "
				+ "can access thru that");
//		Keywords k = new Keywords(); // Error | this is illegal way to call parameterized constructor
		Keywords k = new Keywords(21);
	}
}
