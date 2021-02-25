package day5;

public class applets {

	public static void main(String[] args) {
		int i, j;
		outer: for (i = 1; i < 3; i++)
			inner: for (j = 1; j < 3; j++) {
				if (j == 2)
					continue outer;
				System.out.println("Value for i=" + i + " Value for j=" + j);
			}
		System.out.println(Math.ceil(-4.7)); // it will give -4.0

		Integer ten = new Integer(10); // The constructor Integer(int) is deprecated since version 9
		Long nine = new Long(9);// The constructor Long(long) is deprecated since version 9
		System.out.println(ten + nine); // 19
		int k = 1;
		System.out.println(k + ten); // 11

		String s = new String("Bicycle");
		int iBegin = 1;
		char iEnd = 3;
		System.out.println(s.substring(iBegin, iEnd)); // ic
		System.out.println(s.charAt(2)); // can be used find the position of character from string

		String s1 = new String("Hello");
		String s2 = new String("there");
		String s3 = new String();
		s3 = s1 + s2; // Legal way to concat
		System.out.println(s3);
		System.out.println(4 | 3); // 7

	}

	private class Innerclass { // public private and static are allowded

	}

	int x = 0;

	public int run() {
		while (true) {
			x++;
			System.out.println("i=" + x);
		} // End while

	}// End run

}

//output 
//Value for i=1 Value for j=1
//Value for i=2 Value for j=1
