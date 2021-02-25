package day_8;

public class Ques5 {
	public static void main(String[] args) {
		Counter counter1 = new Counter();
		Counter counter2 = new Counter();
		Counter counter3 = new Counter();
		Counter counter4 = new Counter();
		System.out.println(Counter.count);
	}

}

class Counter {
	public static int count = 0;

	public Counter() {
		count++;
	}
}