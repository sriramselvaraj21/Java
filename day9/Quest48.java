package day9;

public class Quest48 {

	public static void main(String[] args) {
		Demo demo = new Demo(1, 2);
		Demo demo1 = new Demo(1.2, 2.6);

	}

}

class Demo {
	public Demo(int a, int b) {
		System.out.println(a + b);
	}

	public Demo(double a, double b) {
		System.out.println(a + b);
	}

}
