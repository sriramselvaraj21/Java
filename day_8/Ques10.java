package day_8;

public class Ques10 {
	public static void main(String[] args) {
		C c = new C();
	}
}

class A {
	public A() {
		System.out.println("class A");
	}
}

class B {
	public B() {
		// TODO Auto-generated constructor stub
		System.out.println("class B");
	}
}

class C extends A {
	B b = new B();
}