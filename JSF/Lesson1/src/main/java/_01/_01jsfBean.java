package _01;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


// import jakarta.faces.bean.ManagedBean;
// import jakarta.faces.bean.SessionScoped;
// @ManagedBean // -> JSF 2.3 ile birlikte managed bean'ler deprecated olmuştur.
// Artık CDI bean'lerin kullanılması önerilmektedir.


@ManagedBean //  default olarak -> _01jsfBean
@SessionScoped
public class _01jsfBean {
	private String name;
	private String password;
	private _02InnerObj address;

	public _01jsfBean() {
		address = new _02InnerObj();
	}

	public _01jsfBean(String name, String password, _02InnerObj address) {
		super();
		this.name = name;
		this.password = password;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public _02InnerObj getAddress() {
		return address;
	}

	public void setAddress(_02InnerObj address) {
		this.address = address;
	}
	
	

}
