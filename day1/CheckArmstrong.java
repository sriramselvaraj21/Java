package day1;

public class CheckArmstrong {
	static int flag = 1;

	static void CheckPallindrome(int number, int flag) {
		int r, sum = 0, temp;

		temp = number;
		while (number > 0) {
			r = number % 10; // getting remainder
			sum = (sum * 10) + r;
			number = number / 10;
		}
		if (temp == sum) {
			System.out.println(number + " is palindrome number ");
			flag++;
		} else {
			System.out.println(number + " is not a palindrome");
		}
	}

	static void CheckPerfectNumber(int number, int flag) {
		int Sum = 0;

		for (int i = 1; i < number; i++) {
			if (number % i == 0) {
				Sum = Sum + i;
			}
		}
		if (Sum == number) {
			System.out.format(number + "is a Perfect Number");
			flag++;
		} else {
			System.out.format(number + "is NOT a Perfect Number");
		}

	}

	static void CheckArmStrong(int number, int flag) {
		int c = 0, a, temp;
		temp = number;
		while (number > 0) {
			a = number % 10;
			number = number / 10;
			c = c + (a * a * a);
		}
		if (temp == c) {
			System.out.println(number + "is an armstrong number");
			flag++;
		} else {
			System.out.println(number + "is not an armstrong number");
		}

	}

	public static void main(String[] args) {
		int number = 21;
		flag = 0;
		CheckArmStrong(number, flag);
		CheckPallindrome(number, flag);
		CheckPerfectNumber(number, flag);
		if (flag == 0) {
			System.out.println("\n None of these");
		}

	}
}
