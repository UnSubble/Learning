import lombok.*;


// @ToString(exclude = {"id"}) // toString()'ten çıkarır.
@ToString(of = {"name", "surname"})
@EqualsAndHashCode // yine of ve exclude var.
@NoArgsConstructor // empty ctor
@AllArgsConstructor() // hepsi için
// @RequiredArgsConstructor // final field'lar zorunlu olduğundan noargs kullanamayız. Onun yerine bunu kullan.
@Getter
@Setter
@NonNull // requiresNonNull yapar.
public class _01Person {

	@Setter(value = AccessLevel.PRIVATE) // sadece id'nin setter'ını private yaptık.
	private Long id;
	private String name;
	private String surname;
}
