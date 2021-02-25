package day1;

public class FindLocation {
	public static void main(String[] args) {
		int[] intArr = new int[] { 1, 51, 5, 7, 9, 74, 5, 2, 52, 21, 3, 6 };
		int key = 21;
		for (int i = 0; i < intArr.length; i++) {
			if (intArr[i] == key) {
				System.out.println("element found at : " + i);
			}
		}
	}
}
