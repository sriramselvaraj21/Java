package day_8;

public class Ques9 {
	public static void main(String[] args) {
		Sub s = new Sub();
		s.method();
	}
}

class Base {
	private int a = 1;
	public int b = 1;
	protected int c = 1;

}

class Sub extends Base {
	public int n = 1;

	public void method() {
		//System.out.println(a); error| private member cannot be accessed without getter setter
		System.out.println(b);
		System.out.println(c);
		System.out.println(n);
	}
}