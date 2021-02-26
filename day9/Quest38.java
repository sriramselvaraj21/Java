package day9;

public class Quest38 {
	public static void main(String[] args) {
		int a, c, sum = 0;
		int n = 20, b = 1;
		while (sum <= n) {
			System.out.print(sum + " ");
			a = b; // swap elements
			b = sum;
			sum = a + b; // next term is the sum of the last two terms
		}
	}
}
