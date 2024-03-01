public class Serialization {

}

class Test implements java.io.Serializable {
    private static final Test INSTANCE = new Test();

    // deserilize olurken çalışan metot
    private Object readResolve() {
        return INSTANCE;
    }
}