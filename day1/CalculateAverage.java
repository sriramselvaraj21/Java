package day1;

public class CalculateAverage {
	static void AverageCalculator(int[] intArray, int count) {
		float avg = 0;
		for (int i = 0; i < count; i++) {
			avg += intArray[i];
		}
		System.out.println("The average of given array numbers is : " + avg / count);

	}

	public static void main(String[] args) {
		int[] intArray = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int count = 10;
		AverageCalculator(intArray, count);
	}
}
