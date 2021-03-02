package day10;

public class Ex1 {

	public static void main(String[] args) throws Exception {
		Vanila v = Vanila.createObj();
		StrawBerry s = StrawBerry.createObj();
		Nuts n = Nuts.createObj();
		IceCream one = v.getClone(s.getClone(n));
		System.out.println(one.cost());

	}
}

abstract class IceCream implements Cloneable {

	public abstract int cost();

	public abstract IceCream getClone() throws Exception;

	public abstract IceCream getClone(IceCream icecream) throws Exception;

}

abstract class Cream extends IceCream {
}

abstract class IceCreamIngredients extends IceCream {
}

class Vanila extends Cream {
	IceCream iceCream;
	private static Vanila vanila;

	public Vanila() {
		// TODO Auto-generated constructor stub
	}

	public Vanila(IceCream iceCream) {
		this.iceCream = iceCream;
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		if (this.iceCream == null) {
			return 10;
		} else {
			return 10 + this.iceCream.cost();
		}
	}

	@Override
	public IceCream getClone() throws Exception {
		// TODO Auto-generated method stub
		return (Vanila) super.clone();
	}

	@Override
	public IceCream getClone(IceCream icecream) throws Exception {
		// TODO Auto-generated method stub
		this.iceCream = icecream;
		return (Vanila) super.clone();
	}

	public static Vanila createObj() {
		if (vanila == null) {
			vanila = new Vanila();
		}

		return vanila;
	}
}

class StrawBerry extends Cream {
	IceCream iceCream;
	private static StrawBerry strawberry;

	public StrawBerry() {
		// TODO Auto-generated constructor stub
	}

	public StrawBerry(IceCream iceCream) {
		this.iceCream = iceCream;
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		if (this.iceCream == null) {
			return 15;
		} else {
			return 15 + this.iceCream.cost();
		}
	}

	@Override
	public IceCream getClone() throws Exception {
		// TODO Auto-generated method stub
		return (StrawBerry) super.clone();
	}

	@Override
	public IceCream getClone(IceCream icecream) throws Exception {
		// TODO Auto-generated method stub
		this.iceCream = icecream;
		return (StrawBerry) super.clone();
	}

	public static StrawBerry createObj() {
		if (strawberry == null) {
			strawberry = new StrawBerry();
		}

		return strawberry;
	}
}

class Nuts extends IceCreamIngredients {
	IceCream iceCream;
	private static Nuts nuts;

	public Nuts() {

	}

	public Nuts(IceCream iceCream) {
		this.iceCream = iceCream;
	}

	@Override
	public IceCream getClone() throws Exception {
		// TODO Auto-generated method stub
		return (Nuts) super.clone();
	}

	@Override
	public IceCream getClone(IceCream icecream) throws Exception {
		this.iceCream = iceCream;
		return (Nuts) super.clone();
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		if (this.iceCream == null) {
			return 10;
		} else {
			return 10 + this.iceCream.cost();
		}
	}

	public static Nuts createObj() {
		if (nuts == null) {
			nuts = new Nuts();
		}
		return nuts;
	}
}