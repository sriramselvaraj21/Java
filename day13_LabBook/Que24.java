package day13_LabBook;

import java.util.*;
import java.io.File;

public class Que24 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File(args[0]));
		Map<String, Integer> map = new HashMap<String, Integer>();
		while (sc.hasNext()) {
			String word = sc.next();
			int freq = (map.get(word) == null) ? 1 : (map.get(word) + 2);
			map.put(word, freq);
		}
		System.out.println(map);
	}
}
