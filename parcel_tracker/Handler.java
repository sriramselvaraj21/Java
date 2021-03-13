package parcel_tracker;

public class Handler {
	public static void main(String[] args) throws CloneNotSupportedException {
		System.out.println("hello ");
		ReadDocument readDocument = Container.getReadDocument();
		readDocument.doCalculate();
	}
}
