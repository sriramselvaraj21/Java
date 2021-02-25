package day1;

public class ProtectedClass {

	public static void main(String[] args) {
		System.out.println("Illegal modifier for the class Base; only public, abstract & final are permitted");
	}
}
//protected class Base {
//	String Method() {
//		return "Wow";
//	}
//}
//class Derived {
//	public void useD() {
//		Base z = new Base();
//		System.out.println("Base says "+z.Method());
//	}
//	
//}
