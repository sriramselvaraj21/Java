package day9;

public class Quest21 {
	public static void main(String[] args) {
		boolean a = true;
		boolean b = false;

		boolean c = a | b;
		boolean d = a & b;
		boolean e = a ^ b;
		boolean f = (!a & b) | (a & !b);
		boolean g = !a;

		System.out.println("C " + c);
		System.out.println("D " + d);
		System.out.println("E " + e);
		System.out.println("F " + f);
		System.out.println("G " + g);

		int x = 20, y = 10;
		int z = x > y ? x : y;//20
		System.out.println(z);

	}
}
