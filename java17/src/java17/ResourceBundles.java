package java17;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class ResourceBundles {
	public static void main(String[] args) {
		Locale us = new Locale("en", "US");
		ResourceBundle rb = ResourceBundle.getBundle("Zoo", us); // Zoo_en_US -> Zoo_en -> Zoo -> 
							 //Zoo_tr_TR (default locale olduğu için) -> Zoo_tr (default locale olduğu için)
																					// sırasıyla bakar.
		rb.keySet().stream().map(k -> k + ": " + rb.getString(k)).forEach(System.out::println);
		
		Properties props = new Properties();
		props.getProperty("name"); // null
		props.getProperty("name", "bob"); // bob
	}
}
