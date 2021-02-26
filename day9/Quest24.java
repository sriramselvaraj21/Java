package day9;

public class Quest24 {
	public static void main(String[] args) {
		System.out.println("areaOfSqure " + areaOfSqure(5));
		System.out.println("perimeterOfSqure " + perimeterOfSqure(5));
		System.out.println("areaOfRectangle " + areaOfRectangle(5, 4));
		System.out.println("perimeteOfRectangle " + perimeterOfRectangle(5, 4));

	}

	static int areaOfSqure(int a) {
		return a *a;

	}

	static int areaOfRectangle(int l, int b) {
		return l * b;
	}

	static int perimeterOfSqure(int a) {
		return 4 * a;

	}

	static int perimeterOfRectangle(int l, int b) {
		return 2 * (l + b);
	}
}
