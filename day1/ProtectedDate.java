package day1;

public class ProtectedDate {

	protected int pro;

	public static void main(String args[]) {
		SubClass1 obj = new SubClass1();
		obj.method();
	}
}

class SubClass1 extends ProtectedDate {
	public void method() {
		pro += 1;
	}
}