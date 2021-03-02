package day11;

import java.util.Scanner;

public class Quest7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n;
		String d;
		int result;
		do {
			n = sc.next();
			d = sc.next();
			try {
				result = Integer.parseInt(n) / Integer.parseInt(d);
				System.out.println(result);
			} catch (ArithmeticException ae) {
				System.out.println("value must be grater than zero");
			} catch (NumberFormatException ne) {
				if (n.charAt(0) == 'q' || n.charAt(0) == 'Q') {
					System.out.println(0);
				}
				System.out.println("invalid input");
			}
		} while (true);
	}
}
