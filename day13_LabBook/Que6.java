package day13_LabBook;

import java.util.ArrayList;
import java.util.List;

public class Que6 {
	public static void main(String[] args) {
		int input[] = { 1, -2, 0, 5, -1 };
		int target = 2;
		Que6 obj = new Que6();
		System.out.println(obj.threeSum(input, target));
	}

	public List<List<Integer>> threeSum(int num[], int target) {
		List<List<Integer>> list = new ArrayList<>();

		for (int i = 0; i < num.length; i++) {
			for (int j = i; j < num.length; j++) {
				for (int k = j; k < num.length; k++) {
					if (i != j && j != k && i != k && (num[i] + num[j] + num[k] == target)) {
						List<Integer> list2 = new ArrayList<>(3);
						list2.add(num[i]);
						list2.add(num[i]);
						list2.add(num[i]);
						list.add(list2);
					}
				}
			}
		}

		return list;
	}
}