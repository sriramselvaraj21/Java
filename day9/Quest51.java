package day9;

public class Quest51 {
	public static void main(String[] args) {
		B1 b = new B1();
		b.print();
	}
}

class A1 {
	int i = 0;

	void print() {
		i = 10;
		System.out.print(i);
	}

}

class B1 extends A1 {
	void print() {
		super.print();

	}
}