/*
Annotation için @interface oluşturulur.
Target ve Retention annotationları verilir.


*/

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME);
@Target(ElementType.METHOD)
public @interface annotation {

}