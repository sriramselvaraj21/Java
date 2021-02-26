package day9;

public class Quest28 {
	public static void main(String[] args) {
		int month = 4;
		if (month >= 1 && month <= 3) {
			System.out.println("summer");
		} else if (month >= 3 && month <= 6) {
			System.out.println("autumn");
		} else if (month >= 6 && month <= 9) {
			System.out.println("rainy");
		} else {
			System.out.println("spring");
		}
	}
}
