package _04;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class CheckboxBean implements Serializable {

	private boolean contactMe;
	private String[] progLanguages;
	private String[] frameworks = { "hibernate" };
	private String[] jpaFrameworks;

	public String[] getJpaFrameworks() {
		return jpaFrameworks;
	}

	public void setJpaFrameworks(String[] jpaFrameworks) {
		this.jpaFrameworks = jpaFrameworks;
	}

	public String[] getFrameworks() {
		return frameworks;
	}

	public void setFrameworks(String[] frameworks) {
		this.frameworks = frameworks;
	}

	public String[] getProgLanguages() {
		return progLanguages;
	}

	public void setProgLanguages(String[] progLanguages) {
		this.progLanguages = progLanguages;
	}

	public boolean getContactMe() {
		return contactMe;
	}

	public void setContactMe(boolean contactMe) {
		this.contactMe = contactMe;
	}
}
