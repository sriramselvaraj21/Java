package shoppingapplication.model;

import java.util.ListResourceBundle;

public class Dictionary_ta extends ListResourceBundle{
	Object obj[][]= {
			{"username","உன�? பெயர�?" },
			{"password","கடவ�?ச�? சொல�? " },
	};
	@Override
	protected Object[][] getContents() {
		return obj;
	}
}
