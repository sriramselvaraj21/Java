package day9;

public class Quest36 {
	public static void main(String[] args) {
		checkPallindromeNumber();
		checkPallindromeString("sriram");
	}

	static void checkPallindromeNumber() {
		int rem, rev = 0, temp;
		int n = 121;
		temp = n;

		while (n != 0) {
			rem = n % 10;
			rev = rev * 10 + rem;
			n = n / 10;
		}

		if (temp == rev)
			System.out.println(temp + " is a palindrome.");
		else
			System.out.println(temp + " is not a palindrome.");
	}

	static void checkPallindromeString(String s) {
		String reverse = new StringBuffer(s).reverse().toString();

		if (s.equals(reverse))
			System.out.println("Yes, it is a palindrome");

		else
			System.out.println("No, it is not a palindrome");

	}
}
