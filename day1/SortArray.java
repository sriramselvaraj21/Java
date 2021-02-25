package day1;

public class SortArray {
	static void SortDecendingOrder(int[] intArr, int temp) {
		for (int i = 0; i < intArr.length; i++) {
			for (int j = i + 1; j < intArr.length; j++) {
				if (intArr[i] < intArr[j]) {
					temp = intArr[i];
					intArr[i] = intArr[j];
					intArr[j] = temp;
				}
			}
		}
		System.out.println("Elements of array sorted in descending order:");
		for (int i = 0; i < intArr.length; i++) {
			System.out.print(intArr[i] + " ");
		}

	}

	static void SortAscendingOrder(int[] intArr, int temp) {
		for (int i = 0; i < intArr.length; i++) {
			for (int j = i + 1; j < intArr.length; j++) {
				if (intArr[i] > intArr[j]) {
					temp = intArr[i];
					intArr[i] = intArr[j];
					intArr[j] = temp;
				}
			}
		}
		System.out.println("Elements of array sorted in ascending order:");
		for (int i = 0; i < intArr.length; i++) {
			System.out.print(intArr[i] + " ");
		}

	}

	public static void main(String[] args) {
		// Initialize array
		int[] arr = new int[] { 5, 2, 8, 7, 1 };
		int temp = 0;

		SortDecendingOrder(arr, temp);
		System.out.println();
		SortAscendingOrder(arr, temp);

	}
}
