package day5;

public class Ref {
	public static void main(String argv[]) {

		Ref r = new Ref();
		r.amethod(r);

//		int iRand;        
//		//iRand = Math.random();    // Type mismatch: cannot convert from double to int    
//		System.out.println(iRand);
	}

	public void amethod(Ref r) {
		int i = 99;
		multi(r);
		System.out.println(i);
	}

	public void multi(Ref r) {
		// r.i = r.i * 2;
	}

}

//Error at compile time

//The variable i is created at the level of amethod and will not be available inside the method multi.
