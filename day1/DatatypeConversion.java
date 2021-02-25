package day1;

public class DatatypeConversion {
	public static void main(String[] args) {
		int n = 19;
		long lon;
		float flo;
		char ch = 'a';
		double d = 19.2;
		lon = n;
		flo = lon;
		ch = (char) n;
		long l1 = (long) d;
		int i1 = (int) l1;

		System.out.println("integer : " + n);
		System.out.println("integer to long : " + lon);
		System.out.println("integer to float : " + flo);
		System.out.println("integer to char :" + ch);
		System.out.println("integer value" + n);
		System.out.println("double value " + d);
		System.out.println("long value " + l1);
		System.out.println("integer value : " + i1);
	}
}
