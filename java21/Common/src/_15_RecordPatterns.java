record Sorcerer(String skill, double pow) {
}

record Obj(Object o1, Object o2) {
}

@SuppressWarnings("preview")
void main() {
	Object s = new Sorcerer("fire", 100);
	
	if (s instanceof Sorcerer(String str, double p)) {
		System.out.println(STR."Skill: \{str}, pow: \{p}");
	}
	
	Obj o = new Obj("test", "123");
	Obj o2 = new Obj(123, 456);
	Obj o3 = new Obj("test", 123);
	
	print(o);
	print(o2);
	print(o3);
	
	pair(new Pair<>(new A(), new B()));
	pair(new Pair<>(new A(), new A()));
}

void print(Obj o) {
	switch (o) {
	case Obj(String s1, String s2) -> System.out.println("string obj");
	case Obj(Integer i1, Integer i2) -> System.out.println("integer obj");
	default -> System.out.println("unknown obj");
	}
}

class A {}
class B extends A {}
record Pair<T> (T t1, T t2) {} // AA BA AB BB

void pair(Pair<A> p) {
	switch (p) { // bütün olasılıkları sağlaması lazım ki burada sağlıyor.
	case Pair<A>(A t1, B t2) -> System.out.println("ab or bb"); 
	case Pair<A>(B t1, A t2) -> System.out.println("ba or bb");
	case Pair<A>(A t1, A t2) -> System.out.println("aa");
	}
}

