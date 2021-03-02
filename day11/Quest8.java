package day11;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Quest8 {
	public static void main(String[] args) {
		int n = 1;
		int mark;
		int sum = 0;
		Scanner sc = new Scanner(System.in);

		do {
			try {
				n++;
				mark = sc.nextInt();
				sum += mark;
			} catch (InputMismatchException ie) {
				n = n - 1;
				System.out.println("enter valid input");
				continue;
			}
		} while (n <= 5);
	}
}
