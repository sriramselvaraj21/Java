package day5;

class one {
	one(int i) {
		System.out.println("base constructor");
	}

	one() {
	}
}

public class Sup extends one {
	public static void main(String argv[]) {
		Sup s = new Sup();
		// One
	}

	Sup() {
		// Two On the line After //Two put super(10);
		super(10);
	}

	public void derived() {
		// Three
	}
}