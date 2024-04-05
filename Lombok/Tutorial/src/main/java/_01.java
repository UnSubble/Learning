import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class _01 {
	public static void main(String[] args) {
		_01Person person = new _01Person();
		person.setName("test");
		person.setSurname("notnull");
		System.out.println(person.getId());
		System.out.println(person);


		_01PersonData personWithBuilder = _01PersonData.builder().id(43L).name("test").build();
		System.out.println(personWithBuilder);

		// _01TestUtilityClass util = new _01TestUtilityClass(); // DOES NOT COMPILE
	}
}
