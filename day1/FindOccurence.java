package day1;

public class FindOccurence {
	public static void main(String[] args) {
		int[] intArr = new int[] { 1, 51, 5, 7, 9, 74, 5, 21, 52, 21, 3, 6 };
		int key = 21, occurence = 0;
		for (int i = 0; i < intArr.length; i++) {
			if (intArr[i] == key) {
				occurence++;
				System.out.println("element found at : " + i);
			}
		}
		System.out.println(occurence + "times occured");
	}
}
