package day5;

//private class Two { //Error at compile time | illegal modifier for the class Two; only public, abstract & final are permitted
//	Two() {
//		int i = 100;
//		System.out.println(i);
//	}
//}

public class Pri {
	static int i = 200;

	public static void main(String argv[]) {
		Pri p = new Pri();
		System.out.println(i);
	}
}