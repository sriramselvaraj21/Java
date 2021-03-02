package day11;

public class Quest6 {
	public static void main(String[] args) throws Exception {
		try {
			Derived d = new Derived();

		} finally {
			System.out.println("Exception handled");
		}
	}
}

class Base {
	public Base() throws Exception {
		throw new CustomException1();
	}
}

class Derived extends Base {
	public Derived() throws Exception {
	}
}

class CustomException1 extends Exception {
	public CustomException1() {
		System.out.println("exception from base");
	}
}