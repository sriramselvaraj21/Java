package day1;

public class CalculateResults {
	static void calculateResult(int marks[][]) {
		int total = 0;
		float avg = 0;
		for (int i = 0; i < marks.length; i++) {
			total = 0;
			for (int j = 0; j < 2; j++) {
				total += marks[i][j];
			}
			avg = (float) total / (float) 2;
			System.out.println("person " + (i + 1) + " Average : " + avg);
		}
	}

	public static void main(String[] args) {

		int marks[][] = new int[][] { { 80, 85 }, { 90, 95 } };
		calculateResult(marks);
	}
}