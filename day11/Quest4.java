package day11;

public class Quest4 {
	public static void main(String[] args) {
		try {
			Quest4 q = new Quest4();
			q.meth(-1);
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

class CustomException extends Exception {
	public CustomException() {
		System.out.println("Exception");
	}
}