package day1;

public class RectangleArray {
	public static void main(String[] args) {
		int noOfRows = 4;
		int value = 1;

		for (int i = 1; i <= noOfRows; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(value + "\t");
				value++;
			}
			System.out.println();
		}
	}
}
