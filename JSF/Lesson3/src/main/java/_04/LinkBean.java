package _04;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class LinkBean implements Serializable {

	public String navigateToPage1() {
		return "page1";
	}
}
