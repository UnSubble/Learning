// normalde tek bir işlemci cycle'ında bir veri işleniyorken
// 128 bitlik bir işlem gücü olan işlemcide aynı anda 8 byte 
// işleyebiliriz. Örneğin 8 tane byte a + byte b işlemini 
// tek cycle'da yapabiliriz. Bu her işlemciye göre değişik-
// lik gösterebilir. Bu yüzden oldukça karmaşık bir yapı oluşur.

import java.util.Random;

import jdk.incubator.vector.*;

public class _16_VectorAPI {
	private static final VectorSpecies<Integer> SPECIES = IntVector.SPECIES_PREFERRED;
	
	private static final int SIZE = 1024 * 10000;
	
	public static final int[] intArray = new int[SIZE];
	
	static {
		Random r = new Random();
		for (int i = 0; i < SIZE; i++) {
			int b = r.nextInt(10, 15);
			intArray[i] = b;
		}
	}
	
	static int scalarSumArray() {
		int l = 0;
		for (int i = 0; i < SIZE; i++) {
			l += intArray[i];
		}
		return l;
	}
	
	static int vectorizedSumArray() {
		int l = 0;
		for (int i = 0; i < SIZE; i += SPECIES.length()) {
			IntVector v = IntVector.fromArray(SPECIES, intArray, i);
			l += v.reduceLanes(VectorOperators.ADD);
		}
		return l;
	}
	
	void main() {
		long start = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			int _ = scalarSumArray();
		}
		System.out.println("End: " + (System.nanoTime() - start) / 1000000.0);
		start = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			int _ = vectorizedSumArray();
		}
		System.out.println("End: " + (System.nanoTime() - start) / 1000000.0);
	}
}