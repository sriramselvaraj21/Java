package day_8;

public class Ques8 {
	// Singleton s = new Singleton(); //error | The constructor Singleton() is not
	// visible
	Singleton s = Singleton.s;
}

class Singleton {
	public static Singleton s = new Singleton();

	private Singleton() {

	}

}