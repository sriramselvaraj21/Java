package day9;

public class Quest34 {
	public static void main(String[] args) {
		int range = 100;
		int avg = 0;
		for (int i = 0; i < range; i++) {
			if (i % 2 != 0) {
				avg += i;
			}
		}
		System.out.println(avg / range);
	}
}
