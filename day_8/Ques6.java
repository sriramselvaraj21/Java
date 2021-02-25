package day_8;

public class Ques6 {
	public static void main(String[] args) {
		StaticMethodImplementation obj = new StaticMethodImplementation();
		obj.method();
	}
}

class StaticMethodImplementation {
	static {
		System.out.println("Static block called");
	}

	public void method() {
		System.out.println("method called");
	}
}