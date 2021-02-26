package day9;

public class Quest31 {
	public static void main(String[] args) {
		int a = 10, b = 20;
		String key = "mul";
		switch (key) {
		case "add":
			System.out.println(a + b);
			break;
		case "sub":
			System.out.println(b - a);
			break;
		case "mul":
			System.out.println(a * b);
			break;
		case "div":
			System.out.println(a / b);
			break;
		default:
			break;
		}

	}
}
