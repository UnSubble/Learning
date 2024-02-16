import java.util.Locale;
import java.util.ResourceBundle;

public class Lokalizasyon {
	public static void main(String[] args) {
		// dosyaların uzantısı .properties
		ResourceBundle resourceBundle = ResourceBundle.getBundle("config", new Locale("tr"));
		ResourceBundle rb2 = ResourceBundle.getBundle("config", new Locale("en"));
		String msg = resourceBundle.getString("message");
		String enMsg = rb2.getString("message");
		System.out.println(msg);
		System.out.println(enMsg);
	}
}
