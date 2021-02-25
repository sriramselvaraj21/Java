package day1;

public class JavaDoc {
	/**
	 * Without public keyword it won't not run since not visible to JVM Without
	 * static key word it won't run since we main method should be instantiated by
	 * JVM(static keyword required) String[] args is required to pass command line
	 * arguments * this will arise runtime error
	 */
	public static void main(String[] args) {
		System.out.println("Welcome");
		System.out.println("classname and file name should be same");// since we are creating a class
	}
}
