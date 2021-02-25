package day1;

public class AccessSpecifiers {
	private int pri;
	protected int pro;
	int nomod;
	public int pub;

	public void printing() {
		System.out.println(pri);
		System.out.println(pro);
		System.out.println(nomod);
		System.out.println(pub);
	}

	public static void main(String[] args) {
		AccessSpecifiers as = new AccessSpecifiers();
		as.printing();
		Subclass sc = new Subclass();
		sc.printing();

	}
}

class Subclass extends AccessSpecifiers {
	public void printing() {
		// System.out.println(pri); // not visible since private
		System.out.println(pro);
		System.out.println(nomod);
		System.out.println(pub);
	}
}
