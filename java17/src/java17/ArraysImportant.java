package java17;

import java.util.Arrays;

public class ArraysImportant {

	public static void main(String[] args) {
		char[] letters = new char[5];
		int[] nums = null;
		char[] nullchararr = null;
		
		System.out.println(letters instanceof Object);
		System.out.println(letters instanceof char[]);
		System.out.println(nums);
		//System.out.println(nullchararr); // throws NullPointerException
		
		int[] numAnimals;
		int []num1Animals;
		int num2Animals[];
		
		// numAnimals = {1,2,3}; // DOES NOT COMPILE
		
		int ids[], types; // ids: int array, types: int
		int[] ids2, types2; // ids: int array, types: int array
		
		String[] bugs = {"cricket", "beetle", "ladybug"};
		System.out.println(bugs.toString());
		
		String[] strings = {"stringValue"};
		Object[] objects = strings;
		String[] againStrings = (String[]) objects;
		// againStrings[0] = new StringBuilder(); // DOES NOT COMPILE
		// objects[0] = new StringBuilder(); // throws ArrayStoreException
		
		Animals[] animals = new Dog[3];
		animals[0] = new Dog();
		animals[1] = new Dog();
		animals[2] = new Dog();
		Dog[] dogs = (Dog[]) animals;
		// animals[0] = new Cat(); // throws ArrayStoreException
		
		System.out.println(Arrays.compare(new int[] {1}, new int[] {1})); // 0
		System.out.println(Arrays.compare(new int[] {1}, new int[] {2})); // negatif
		System.out.println(Arrays.compare(new int[] {1,2}, new int[] {2})); // negatif
		System.out.println(Arrays.compare(new int[] {1,2}, new int[] {1})); // pozitif
		System.out.println(Arrays.compare(new int[] {1,2,5,3,20}, new int[] {3})); // negatif
		System.out.println(Arrays.compare(new int[] {1,2,-1}, new int[] {1,2})); // pozitif
		System.out.println(Arrays.compare(new int[] {1,2}, new int[] {1,2,-1})); // negatif
		System.out.println(Arrays.compare(new String[] {"a"}, new String[] {"aa"})); // negatif
		System.out.println(Arrays.compare(new String[] {"a"}, new String[] {"A"})); // pozitif
		System.out.println(Arrays.compare(new String[] {"a"}, new String[] {"Z"})); // pozitif
		System.out.println(Arrays.compare(new String[] {"a"}, new String[] {null})); // pozitif
		
		// iki array aynı elemanlara aynı sırada sahipse 0 döner.
		// bütün elemanlar aynıysa ve ikinci array sonda ekstradan 1 tane daha değere sahipse negatif döner.
		// bütün elemanlar aynıusa ama ilk array sonda ekstradan 1 tane daha değere sahipse pozitif döner.
		// büyük harfler küçük harflerden daha küçüktür.
		// null değer harften daha küçüktür.
		// ilk arraydeki ilk farklı eleman ikinci arraydekinden küçükse negatif döner.
		// ilk arraydeki ilk farklı eleman ikinci arraydekinden büyükse pozitif döner.
		
		System.out.println(Arrays.mismatch(new int[] {1}, new int[] {1})); // -1
		System.out.println(Arrays.mismatch(new int[] {1}, new int[] {0})); // 0
		System.out.println(Arrays.mismatch(new int[] {1,2}, new int[] {1})); // 1
		System.out.println(Arrays.mismatch(new int[] {1,2,-1}, new int[] {1,2,-1,5})); // 3
		
		int[] arr[];
		int[] arr2[], arr3[][]; // arr2: 2D, arr3: 3D
		
		int[][] arr4 = new int[3][6];
		int[] arr5 = new int[8];
		arr4[0] = new int[5];
		arr4[1] = new int[2];
		// arr4[2] = arr5; // DOES NOT COMPILE
		
	}
	
	static class Animals{
	}
	
	static class Dog extends Animals {
	}
	
	static class Cat extends Animals {
	}

}
