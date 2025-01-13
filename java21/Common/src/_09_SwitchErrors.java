void main() {
	nums(16);
	err(17L);
}

void nums(Object obj) {
	switch (obj) {
	case Integer i -> System.out.println("instance of integer");
	case Long l -> System.out.println("instance of long");
	case Number n -> System.out.println("instance of number"); // bu 7. satıra konulmuş olsaydı 
                                                              // java error verirdi.
	case Object o -> System.out.println("instance of object");
	}
}

void err(Number num) {
	switch (num) {
	case Integer i -> System.out.println("instance of integer");
	case Long l -> System.out.println("instance of long");
	case Number n -> System.out.println("instance of number");
	// default -> System.out.println("instance of object"); // -> zaten üstteki case her durumu kapsadığından
	                                                        // default statement'ına gerek yoktur.
	}
}

// -------------------------------------------------------------

sealed interface S permits A, B, C { // sealed class olduğundan anonim obje oluşturulamaz.
}                                    // bu yüzden alttaki switch'te sadece permit ettiklerine 
                                     // case yazarsak valid olur.

non-sealed class A implements S {
}

final class B implements S {
}

record C() implements S {
}

static void switchStatementExhaustive(S s) { 
	switch (s) {
	case A a:
		System.out.println("a");
		break;
	case B b:
		System.out.println("b");
		break;
	case C c:
		System.out.println("c");
		break;
	}
}


