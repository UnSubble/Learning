import lombok.Builder;
import lombok.Data;


@Data // getter setter equalsAndHashcode toString ve requiredArgsConstructor'ı bu annotation ile yapabiliriz.
@Builder // builder design pattern uyumluluğu için
public class _01PersonData {
    private Long id;
    private String name;
    private String surname;
}
