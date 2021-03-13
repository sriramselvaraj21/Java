package parcel_tracker;

import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class ReadDocument implements Cloneable, Calculator {
	public static ReadDocument object = null;

	public ReadDocument() {
		// TODO Auto-generated constructor stub
	}

	public static ReadDocument createObject() {
		if (object == null) {
			object = new ReadDocument();
		}
		return object;
	}

	public ReadDocument getClonedObject() throws CloneNotSupportedException {
		return (ReadDocument) super.clone();
	}

	public void doCalculate() {
		SAXBuilder builder = new SAXBuilder();
		Document jdomDoc;
		try {
			jdomDoc = (Document) builder
					.build("C:\\Users\\AW126XW\\eclipse-workspace\\EY_Learing\\src\\parcel_tracker\\details.xml");
			Element root = jdomDoc.getRootElement();
			List<Element> listOfParcel = root.getChildren("parcel");
			List<Parcel> parcelList = new ArrayList<>();
			for (Element element : listOfParcel) {
				Parcel parcel = new Parcel();
				parcel.setId(Integer.parseInt(element.getAttributeValue("id")));
				parcel.setStartdate(element.getChildText("startdate"));
				parcel.setStarttime(element.getChildText("starttime"));
				parcel.setOrigin(element.getChildText("origin"));
				parcel.setDestination(element.getChildText("destination"));
				parcel.setSpeed(element.getChildText("speed"));
				parcel.setBreaktime(element.getChildText("breaktime"));
				parcel.setDistance(element.getChildText("distance"));
				parcelList.add(parcel);
			}

			for (Parcel parcel : parcelList) {
				double endtime = 0;
				endtime += Integer.parseInt(parcel.getBreaktime());
				endtime += Integer.parseInt(parcel.getDistance()) / Integer.parseInt(parcel.getSpeed());
				System.out.println("your parcel will reach after " + endtime / 24 + "days");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
