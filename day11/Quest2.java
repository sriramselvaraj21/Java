package day11;

import java.io.IOException;

public class Quest2 {
	public void mth1() {
		mth2();
		System.out.println("caller");
	}

	public void mth2() {
		try {
			throw new IOException();
		} catch (Throwable e) {
			System.out.println("catch meth2");
		} finally {
			System.out.println("finally math2");
		}
	}

	public static void main(String[] args) {
		Quest2 q = new Quest2();
		q.mth1();
	}
}
