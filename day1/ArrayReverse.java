package day1;

public class ArrayReverse {
	public static void main(String[] args) {
		int[] intArr = new int[] { 1, 51, 5, 7, 9, 74, 5, 2, 52, 21, 3, 6 };
		for (int i = intArr.length - 1; i >= 0; i--) {

			System.out.print(intArr[i] + "  ");

		}
	}
}
