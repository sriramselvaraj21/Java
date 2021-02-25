package day1;

public class ReverseArray {
	static int[][] reversecolumn(int a[][], int row, int column) {
		int reversed[][] = new int[row][column];
		int k = 0;
		for (int i = 0; i < row; ++i) {
			k = 0;
			for (int j = column - 1; j >= 0; --j) {
				reversed[i][k++] = a[i][j];
			}
		}
		return reversed;
	}

	public static void main(String[] args) {
		int[][] arr = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		arr = reversecolumn(arr, 3, 3);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
}
