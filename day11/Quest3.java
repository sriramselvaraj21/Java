package day11;

public class Quest3 {
	public void mth1() {
		mth2();
		System.out.println("caller");
	}

	public void mth2() {
		try {
			System.exit(0); // force termination | finally block won't execute.
		} catch (Throwable e) {
			System.out.println("catch meth2");
		} finally {
			System.out.println("finally math2");
		}
	}

	public static void main(String[] args) {
		Quest3 q = new Quest3();
		q.mth1();
	}
}