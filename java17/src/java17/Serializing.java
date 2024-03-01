package java17;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serializing {
	public static void main(String[] args) {
		// bir class serializable ise içindeki class'lar da serializible olmalı. Eğer ilgili değişken null 
			// ise serializible olmasına gerek yoktur çünkü zaten null'dır.
	}
}

class Gorilla implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private transient String favoriteFood;
	
	public Gorilla(String name, int age, String favoriteFood) {
		super();
		this.name = name;
		this.age = age;
		this.favoriteFood = favoriteFood;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getFavoriteFood() {
		return favoriteFood;
	}
	
	public void setFavoriteFood(String favoriteFood) {
		this.favoriteFood = favoriteFood;
	}
	
	// serileştirme işleminde bu metot çalışır.
	private void writeObject(ObjectOutputStream os) {
		try {
			System.out.println("invoking writeObject...");
			os.defaultWriteObject();
			os.writeInt(age); // ekstra olarak değer yazdırıyoruz.
		} catch (Exception e) {
		}
	}
		
	// deserileştirme işleminde bu metot çalışır.
	private void readObject(ObjectInputStream is) {
		try {
			System.out.println("invoking readObject...");
			is.defaultReadObject();
			age = is.readInt();
		} catch (Exception e) {
		}
	}
	
	@Override
	public String toString() {
		return "Gorilla [name=" + name + ", age=" + age + "]";
	}	
}