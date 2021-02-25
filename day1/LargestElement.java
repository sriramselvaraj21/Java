package day1;

public class LargestElement {
	public static void main(String[] args) {
		int[][] arr = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int max = 0;
		for (int i = 0; i < 3; ++i) {
			max = 0;
			for (int j = 0; j < 3; ++j) {
				if (arr[i][j] > max) {
					max = arr[i][j];
				}
			}
			System.out.println(max);
		}
	}
}
