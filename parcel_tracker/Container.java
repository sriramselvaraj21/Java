package parcel_tracker;

public class Container {
	public static ReadDocument getReadDocument() throws CloneNotSupportedException {
		ReadDocument object;
		object = ReadDocument.createObject().getClonedObject();
		return object;
	}
}
