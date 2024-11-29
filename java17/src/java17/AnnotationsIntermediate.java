package java17;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;


public class AnnotationsIntermediate {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(Dolphin.class.getAnnotations())); // [@java17.Vertebrate()]
		System.out.println(Arrays.toString(Mammal.class.getAnnotations())); // [@java17.Vertebrate()]
	}
}

// @Inherited annotation'ı bir annotation'ın üstüne yazılır. Bu annotation'ı alan sınıfı kalıtan diğer 
// sınıfların da ilgili annotation'ı almasını sağlar.

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Vertebrate {
	
}

@Vertebrate
class Mammal {
	
}

class Dolphin extends Mammal {
	
}

// Aynı annotation'ı birden fazla kez farklı değerlerle kullanmak için @Repeatable kullanılır.
// Repeatable annotation'ını kullanabilmek için annotation içeren annotation kullanmamız lazım.
// İçerideki annotation tekrar edilecek annotation'ın array'ini value olarak almalıdır.

@Repeatable(Vertebrate2s.class)
@interface Vertebrate2 {
	
	String danger() default "";
	
	int level() default 1;
}

@interface Vertebrate2s { // genelde çoğul hali kullanılır.
	Vertebrate2[] value();
}

@Vertebrate2(danger = "high", level = 3)
@Vertebrate2(danger = "low")
@Vertebrate2(danger = "medium", level = 2)
class Mammal2 {
	
}


// --------- SafeVarArgs ---------
// override edilemeyen metodlar üzerinde kullanılır.
// @SuppressWarnings("unchecked") kıyasla bu da raw type kullanıldığını fakat uyarıları suppress 
// etmek amacıyla kullanılır. 
// yine de kodda raw type kullandığımız için kod unsafe olur.
// kısaca amacı developer'lara bu metodda raw type kullanıldığını ama bilinçli yapıldığını göstermek için
// kullanılır.

