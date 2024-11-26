package _07;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class PeopleBean implements Serializable {
	private List<Person> people;

	public PeopleBean() {
		people = new ArrayList<>();
		people.add(new Person() {
			{
				setAge(10);
				setGender('M');
				setName("ahmet");
				setSurname("yıldız");
			}
		});
		people.add(new Person() {
			{
				setAge(50);
				setGender('F');
				setName("fatma");
				setSurname("yılmaz");
			}
		});
		people.add(new Person() {
			{
				setAge(56);
				setGender('M');
				setName("mehmet");
				setSurname("yılan");
			}
		});
	}

	public List<Person> getPeople() {
		return people;
	}

	public void setPeople(List<Person> people) {
		this.people = people;
	}

}
