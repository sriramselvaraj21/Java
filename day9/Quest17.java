package day9;

public class Quest17 {
	public static void main(String[] args) {
		int a = 10;
		int b = 15;
		System.out.println(add(a, b));
		System.out.println(sub(a, b));
		System.out.println(mul(a, b));
		System.out.println(div(a, b));

	}

	static int add(int a, int b) {
		a += b;
		return a;
	}

	static int sub(int a, int b) {
		b -= a;
		return b;
	}

	static int mul(int a, int b) {
		b *= a;
		return b;
	}

	static int div(int a, int b) {
		b /= a;
		return b;
	}
}
