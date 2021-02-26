package day9;

public class Quest50 {
	public static void main(String[] args) {
		C c = new C();
		c.printC();
		c.printB();
		c.printA();
	}
}

class A {
	void printA() {
		System.out.println("class A");
	}
}

class B extends A {
	void printB() {
		System.out.println("class B");
	}
}

class C extends B {
	void printC() {
		System.out.println("class C");
	}
}