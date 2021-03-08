package day13_LabBook;

import java.util.*;

public class Que23 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Alpha");
		list.add("Beta");
		list.add("Gamma");

		Object[] stringArray1 = list.toArray();
		System.out.println(Arrays.toString(stringArray1));
		Object[] stringArray2 = list.toArray(new String[0]);
		stringArray2[1] = "delta";
		System.out.println(Arrays.toString(stringArray2));
		System.out.println(list);

	}
}
