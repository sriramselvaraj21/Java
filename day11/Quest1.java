package day11;

import java.io.IOException;

public class Quest1 {
	public static void main(String[] args) {
		Test t = new Test();
		t.meth();
	}
}

class Test {
	void meth() {
		try {
			throw new IOException();
		} catch (Exception e) {

		}
	}
}