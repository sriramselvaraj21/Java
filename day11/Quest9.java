package day11;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Quest9 {
	public static void main(String[] args) throws InvalidInputException, LimitExceedException {
		int n = 1;
		int mark;
		int sum = 0;
		Scanner sc = new Scanner(System.in);

		do {
			n++;
			mark = sc.nextInt();
			try {
				if (mark < 0) {
					throw new InvalidInputException("enter valid number");
				} else if (mark > 100) {
					throw new LimitExceedException("enter valid number");
				}
			} catch (InputMismatchException ie) {
				n = n - 1;
				System.out.println("enter valid input");
				continue;
			}
		} while (n <= 5);
	}
}

class InvalidInputException extends Exception {
	public InvalidInputException(String str) {
		System.out.println(str);
	}
}

class LimitExceedException extends Exception {
	public LimitExceedException(String str) {
		System.out.println(str);
	}
}
