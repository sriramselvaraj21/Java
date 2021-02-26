package day9;

public class Quest41 {
	public static void main(String[] args) {
		int i, j, row = 4, value = 1;
		for (i = 0; i < row; i++) {
			for (j = 0; j <= i; j++) {
				System.out.print("0 ");
			}
			System.out.println();
		}

		for (i = 1; i <= row; i++) {
			for (j = 1; j <= i; j++) {
				System.out.print(value + " ");

				value++;
			}

			System.out.println();
		}
	}
}
