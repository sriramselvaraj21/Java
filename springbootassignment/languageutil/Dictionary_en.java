package com.utils.languages;

import java.util.ListResourceBundle;

public class Dictionary_en extends ListResourceBundle{
	Object obj[][]= {
			{"username","Username"},
			{"password","Password"}
	};

	
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return obj;
	}
}
