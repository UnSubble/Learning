package _06;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("_06.CustomConverter")
public class CustomConverter implements Converter {

	private static final String HTTP = "http://";

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (!arg2.startsWith(HTTP, 0)) {
			arg2 = HTTP + arg2;
		} else {
			throw new ConverterException();
		}
		return arg2;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return arg2.toString();
	}

}
