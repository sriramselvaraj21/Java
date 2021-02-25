package day5;

class Base {
}

class Sub extends Base {
}

class Sub2 extends Base {
}

public class CEx {
	public static void main(String argv[]) {
		Base b = new Base();
		Sub s = (Sub) b;
	}
}
// runtime exception | class day5.Base cannot be cast to class day5.Sub
