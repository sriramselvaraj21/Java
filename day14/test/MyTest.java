package day14.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.jupiter.api.Test;

class MyTest {

	@Test
	void test() {
		CaculatorDemo calsi = new CaculatorDemo();
		int result = calsi.add(20, 20);
		assertEquals(40, result);
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("1");
	}

	@AfterClass
	public static void setUpAfterClass() throws Exception {
		System.out.println("2");
	}

	@Before
	public static void setUp() throws Exception {
		System.out.println("3");
	}

	@After
	public static void tearDown() throws Exception {
		System.out.println("4");
	}

	@Test
	public void test1() {
		System.out.println("t1");
	}

	@Test
	public void test2() {
		System.out.println("t2");
	}

	@Test
	public void test3() {
		System.out.println("t3");
	}
}
