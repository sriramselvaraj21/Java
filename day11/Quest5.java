package day11;

public class Quest5 {
	public static void main(String[] args) {
		Demo d = new Demo();

		try {
			d.meth(-1);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("finally");
		}
	}

	public void meth(int i) throws Exception {
		if (i < 0) {
			throw new CustomException();
		}
		System.out.println("value = " + i);
	}

}

class Demo {
	public void meth(int i) throws Exception {
		if (i < 0) {
			throw new CustomException();
		}
		System.out.println(i);
	}

}