package java17;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class IOStreams {
	public static void main(String[] args) throws FileNotFoundException {
		// I/O streamlerin hepsinin üst sınıfları InputStream, OutputStream, Reader ve Writer abstract 
																						// class'larıdır.
		
		// FileReader karakter karakter okur.
		// ObjectInputStream obje olarak okur.
		// InputStream byte byte okur.
		
		// high level IO streamler (BufferedReader gibi) low level streamleri (InputStreamReader gibi)
			// constructor'ları ile alırlar.
		
		
		// Class Name            Low/High Level       Description		
		// FileInputStream       Low                  Tüm dosyayı byte'larla okur.		
		// FileOutputStream      Low                  Tüm dosyayı byte'larla yazar.
		// FileReader            Low                  Tüm dosyayı karakter(char) halinde okur.
		// FileWrite             Low                  Tüm dosyayı karakter halinde yazar.
		// BufferedInputStream   High                 InputStream ile byte halinde parça parça okuma yapar.
												  //  Bu da performansı arttırır.
		// BufferedOutputStream  High                 OutputStream ile byte halinde parça parça yazma ya-
												  //  par. Bu da performansı arttırır.
		// BufferedReader        High                 Reader ile karakter halinde parça parça okuma yapar.
												  //  Bu da performansı arttırır.
		// BufferedWriter        High                 Writer ile karakter halinde parça parça yazma yapar.
												  //  Bu da performansı arttırır.
		// ObjectInputStream     High                 Java objesini deserilize eder.
		// ObjectOutputStream    High                 Java objesini serilize eder.
		// PrintStream           High                 Objeleri binary stream'e dönüştürerek formatlı bir 
												  //  şekilde yazar.
		// PrintWriter           High                 Objeleri karakter stream'ine dönüştürerek formatlı 
												  //  bir şekilde yazar.
	
		
		try (PrintStream stream = new PrintStream(new FileOutputStream("output.txt"))) {
			stream.println(2023);
			stream.println("line2");
		}
		
		System.out.println(System.getProperty("line.seperator"));
		System.out.println(System.lineSeparator());
	}	
	
	static void copyStream(InputStream in, OutputStream out) throws IOException {
		int b;
		while ((b = in.read()) != -1) {
			System.out.print((char)b + " ");
			out.write(b);
		}
		out.close();
		in.close();
	}
	
	static void copyStream2(InputStream in, OutputStream out) throws IOException {
		int batchSize = 1024;
		byte[] buffer = new byte[batchSize];
		int b;
		while ((b = in.read(buffer, 0, batchSize)) > 0) {
			System.out.println("lengthRead: " + b);
			out.write(buffer, 0, b);
			out.flush(); // Programın kapanması durumunda verilerin kaybolmaması için. Biriken tüm
																					// verileri yazdırır.
		}
		out.close();
		in.close();
	}
	
	static void copyTextFile(File src, File dest) throws IOException {
		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src), 8192);
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest), 8192)) {
			while (bis.available() > 0) {
				int i = bis.read();
				bos.write(i);
			}
		}
	}
	
	static void copyTextFile2(File src, File dest) throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(src));
				BufferedWriter writer = new BufferedWriter(new FileWriter(dest))) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				writer.write(line);
				writer.newLine();
			}
		}
	}
	
	static void copyTextFile3(File src, File dest) throws IOException {
		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src), 8192);
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest), 8192)) {
			byte[] allBytes = bis.readAllBytes();
			String content = new String(allBytes, StandardCharsets.UTF_8);
			System.out.println(content);
			
			bos.write(allBytes);
		}
	}
	
	static void copyTextFile4(File src, File dest) throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(src));
				BufferedWriter writer = new BufferedWriter(new FileWriter(dest, true))) { // 2. parametre
			String line;												// sonuna eklemesi (append) için.
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				writer.write(line);
				writer.newLine();
			}
		}
	}
	
	static void copyTextFile5(File src, File dest) throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(src));
				PrintWriter writer = new PrintWriter(new FileWriter(dest))) {
			String line;												
			while ((line = reader.readLine()) != null) {
				writer.println(line);
			}
		}
	}
	
	static void copyPathAsString(Path input, Path output) throws IOException {
		String str = Files.readString(input);
		System.out.println(str);
		Files.writeString(output, str);
	}
	
	static void copyPathAsBytes(Path input, Path output) throws IOException {
		byte[] b = Files.readAllBytes(input);
		Files.write(output, b);
	}
	
	static void copyPathAsLines(Path input, Path output) throws IOException {
		List<String> str = Files.readAllLines(input);
		System.out.println(str);
		Files.write(output, str);
	}
	
	static void copyPathAsStream(Path input, Path output) throws IOException {
		Stream<String> str = Files.lines(input); // readAllLines'a göre lazy okuma yapar. Bu yüzden satır 
		str.forEach(System.out::println);        // satır okur ve memory'e böyle kaydeder. readAllLines 
		str.close();							 // ise hepsini aynı anda kaydettiği için memory sıkıntısı 
												 // açığa çıkar.
	}
}
