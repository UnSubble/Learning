package _03;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class AjaxBean2 implements Serializable {

	private String key;
	private String value;
	
	private String selectedFramework;
	private Map<String, String> frameworkMap;
	
	public AjaxBean2() {
		frameworkMap = new LinkedHashMap<>();
		frameworkMap.put("JSF", "java server faces");
		frameworkMap.put("Spring", "spring");
	}
	
	@PostConstruct // constructor'dan sonra çalışmasını sağlar.
	public void init() {
		
	}
	
	public void addFramework(String key, String value) {
		frameworkMap.put(key, value);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getSelectedFramework() {
		return selectedFramework;
	}

	public void setSelectedFramework(String selectedFramework) {
		this.selectedFramework = selectedFramework;
	}

	public Map<String, String> getFrameworkMap() {
		return frameworkMap;
	}

	public void setFrameworkMap(Map<String, String> frameworkMap) {
		this.frameworkMap = frameworkMap;
	}
	
	
}
