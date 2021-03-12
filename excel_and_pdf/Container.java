package excel_and_pdf;

public class Container {
	public static ReadXMLUsingSAX getReadXMLUsingSAX() throws Exception {
		ReadXMLUsingSAX object;
		object = ReadXMLUsingSAX.createObject().getClone();
		return object;
	}

	public static ReadXMLUsingDOM getReadXMLUsingDOM() throws Exception {
		ReadXMLUsingDOM object;
		object = ReadXMLUsingDOM.createObject().getClonedObject();
		return object;
	}
}
