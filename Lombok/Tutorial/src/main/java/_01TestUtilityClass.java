import lombok.experimental.UtilityClass;

@UtilityClass // class'ı final yapar, constructor koydurmaz, metotları da static yapar.
public class _01TestUtilityClass {
    String trim(String val) {
        return val.trim();
    }
}
