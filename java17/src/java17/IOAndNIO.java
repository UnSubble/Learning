package java17;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

public class IOAndNIO {
	@SuppressWarnings("unused") // if (false) {} bloğu için
	public static void main(String[] args) throws IOException {
		Path path = Path.of("text.txt");
		System.out.println(path.getClass());
		
		File toFile = path.toFile();
		System.out.println(toFile.getClass());
		
		Path toPath = toFile.toPath();
		
		Path zooPath = FileSystems.getDefault().getPath("text.txt");
		System.out.println(zooPath);
		
		File file = new File("src" + File.separator + "text.txt"); 
		if (file.exists()) {
			System.out.println("Absolute path: " + file.getAbsolutePath());
			System.out.println("Is Directory: " + file.isDirectory());
			System.out.println("Parent Path: " + file.getParent());
			if (file.isFile()) {
				System.out.println("Size: " + file.length());
				System.out.println("Last Modified: " + file.lastModified());
			}
		}
		
		Path text = file.toPath();
		if (Files.exists(text)) {
			System.out.println("Absolute path: " + text.toAbsolutePath());
			System.out.println("Is Directory: " + Files.isDirectory(text));
			System.out.println("Parent Path: " + text.getParent());
			if (!Files.isDirectory(text)) {
				System.out.println("Size: " + Files.size(text));
				System.out.println("Last Modified: " + Files.getLastModifiedTime(text));
			} else {
				try (Stream<Path> stream = Files.list(text)) { // Files sınıfı streamleri connection açtığı
					stream.forEach(p -> System.out.println(p));  // için mutlaka kapatılmalıdır.
				}
			}
		}
		
		
	// Enum Type               Enum Value           Details
	// LinkOption              NOFOLLOW_LINKS       Sembolik linklere bakmaz.
		
	// StandardCopyOption      ATOMIC_MOVE          Dosyaları atomik olarak taşır.
							// COPY_ATTRIBUTES      Var olan dosyadaki özellikleri de yeni dosyaya kopyalar.
							// REPLACE_EXISTING     Dosya varsa üstüne yazar.
		
	// StandardOpenOption      APPEND               Dosyayı sıfırdan yazmak yerine ekleme yaparak yazar.
							// CREATE				Dosya yoksa yeni oluşturur. Varsa Exception fırlatır.
							// CREATE_NEW           Dosya var olsa da yeni oluşturur.
							// READ                 Okuma erişimi ile dosyayı açar.
							// TRUNCATE_EXISTING    Dosya zaten varsa içini boşaltır.
							// WRITE                Yazma erişimi ile dosyayı açar.
		
	// FileVisitOption         FOLLOW_LINKS         Sembolik linkleri takip eder.
		
		Path newLink = Paths.get("schedule.xml");
		Path target = Path.of("schedule2.xml");
		
		// Files.createSymbolicLink(newLink, target); // bir tane sembolik dosya yaratır.
		
		System.out.println("newLink: " + newLink); // sembolik link
		System.out.println("target: " + target); // asıl link
		
		System.out.println("Files.exists: " + Files.exists(newLink));
		System.out.println("isSymbolicLink: " + Files.isSymbolicLink(newLink));
		System.out.println("Files.exists#NOFOLLOW_LINKS: " +  // Dosyanın olup olmamasına değil path'e 
						Files.exists(newLink, LinkOption.NOFOLLOW_LINKS));                    // bakar.
		System.out.println("Target of link " + newLink + " is " + Files.readSymbolicLink(newLink));
		
		
		// Files.move(newLink, toPath, LinkOption.NOFOLLOW_LINKS, StandardCopyOption.ATOMIC_MOVE);
		
		
		Path txt = Paths.get("C:/users/user/desktop/projects/learning/java17/src/text.txt");
		for (int i = 0; i < txt.getNameCount(); i++) { // root dahil değil
			System.out.println("\tElement " + i + " is: " + txt.getName(i));
		}
		
		
		System.out.println("txt.subpath(0,3): " + txt.subpath(0,3)); // users\\user\\desktop
		System.out.println("txt.subpath(4,6): " + txt.subpath(4,6)); // learning\\java17
		System.out.println("txt.subpath(0,nameCount()): " + txt.subpath(0, txt.getNameCount()));
		
		System.out.println("root path: " + txt.getRoot());
		
		Path path1 = Path.of("C:/cats/../panther");
		Path path2 = Path.of("food");
		System.out.println(path1.resolve(path2)); // C:\\cats\\..\\panther\\food
		
		Path path3 = Path.of("C:/turkey/food");
		Path path4 = Path.of("C:/tiger/cage");
		System.out.println(path3.resolve(path4)); // C:\\tiger\\cage
		
		Path path5 = Path.of("fish.txt");
		Path path6 = Path.of("firendly/birds.txt");
		System.out.println(path5.relativize(path6)); // ..\\firendly\\birds.txt -> path6'ya nasıl gideceği-
																						// mizi gösterir.
		System.out.println(path6.relativize(path5)); // ..\\..\\fish.txt -> path5'e nasıl gideceğimizi
																							// gösterir.
		
		// Path.relativize() metotundaki path'lerin ikisinin de ya absolute ya da relative path olması 
			// gerekiyor. Yoksa IllegalArgumentException fırlatır.
		// Windows sistemlerde root'lar farklı olduğunda da IllegalArgumentException fırlatır.
		
		
		Path p1 = Path.of("C:/cats/../panther/food");
		System.out.println(p1.normalize()); // C:\\panther\\food
		
		Path p2 = Path.of("./../fish.txt");
		System.out.println(p2.normalize()); // ..\\fish.txt
		
		Path p3 = Paths.get("./pony/../weather.txt");
		Path p4 = Paths.get("./weather.txt");
		
		System.out.println(p3.equals(p4)); // false
		System.out.println(p3.normalize().equals(p4)); // false
		System.out.println(p3.normalize().equals(p4.normalize())); // true
		
		
		// System.out.println(Paths.get("zebra/food.txt").toRealPath()); // yoksa exception fırlatır.
		// Path.toRealPath() -> sembolik link olarak bakıyor.
		
		
		//Files.createDirectory(Path.of("bison/field")); // eğer bison adli klasör yoksa exception 
														// fırlatır. Klasör varsa da exception fırlatır.
		// Files.createDirectories(Path.of("bison/field/pasture/green")); // Hepsini oluşturur. Varsa 
																					// exception fırlatmaz.
		
		File folder = new File("mkdir-folder");
		// boolean result = folder.mkdir(); // oluşturabilirse true, zaten varsa false döner. Eğer parent'ı
												// oluşturulmamışsa yeni klasör oluşturamaz ve false döner.
						// folder.mkdirs(); // kendisini de parent klasörlerini de oluşturur. zaten varsa 
												// false döner.
		boolean result = false;
		if (result) {
			File dummy = new File(folder, "dummy-file.xml");
			try {
				boolean fileResult = dummy.createNewFile();
				if (fileResult)
					System.out.println("File was created.");
				else
					System.out.println("File was not created.");
			} catch (IOException e) {
			}
		}
		
		Path tempFile = Files.createTempFile("tmp", null);
		Path tempFile2 = Files.createTempFile(Path.of("src/"), "temp", ".txt");
		File tempFile3 = File.createTempFile("tmp", null, new File("src/java17"));
		
		System.out.println(tempFile); // başı tmp sonrası rastgele uzantısı .tmp olan dosya oluşturur.
							// path belirtmezsek C:\\Users\\user\\AppData\\Local\\Temp path'ine oluşturur.
		System.out.println(tempFile2); // src altında başı temp sonrası rastgele uzantısı .txt olan dosya 
																							// oluşturur.
		Files.deleteIfExists(tempFile);
		Files.deleteIfExists(tempFile2);
		tempFile3.delete();
		
		// Files.copy(Path.of("panda/bamboo.txt"), Path.of("panda-save/bamboo.txt")); // 1. parametredeki 
			// dosyayı 2. parametreye kopyalar. Eğer 2. path varsa veya 1. Path yoksa Exception fırlatır.
			// 2. path varsa ve yine de oluşturmak istiyorsak CopyOptions olarak StandardCopyOption.REPLACE
			// _EXISTING enum value'sunu kullanabiliriz. örn:
		Files.copy(Path.of("panda/bamboo.txt"), Path.of("panda-copy/bamboo.txt"), 
				StandardCopyOption.REPLACE_EXISTING);
		// copy metotu çoklu kopyalama yapmaz. Baştan sona doğru kopyalamak için recursive metot 
			// kullanmamız gerekir. Yani ilk önce parent'ı veririz. Parent'ta da Files.list() metotunu
			// kullanarak recursive yapı oluşturmamız gerekir. Örn: IOAndNIO.copyPath() metotu.
		
		if (false) {
			try (FileInputStream f = new FileInputStream("source-data.txt")) {
				Files.copy(f, Path.of("mammals/wolf.txt"));
			}
		
			Files.copy(Paths.get("fish/clown.xsl"), System.out);
		
		
		Path p7 = Paths.get("food.txt");
		Path directory = Paths.get("enclosure");
		Files.copy(p7, directory); // dosyayı klasöre kopyalamaya çalışmaz. Onun yerine enclosure isimli 
		// dosya (klasör değil) oluşturmaya çalışır. Eğer bu isimde bir dosya (klasör de dahil) varsa 
		// exception fırlatır. StandardCopyOption.REPLACE_EXISTING ile bu dosyayı ezebiliriz. Fakat klasör
		// doluysa yine exception fıraltır.
		
		
		Files.move(Path.of("zoo"), Path.of("zoo-new")); // zoo isimli klasörün ismini zoo-new olarak 
										// değiştirir. Yine sadece child'a bakar. Parent'ları oluşturmaz.
		Files.move(Path.of("src/zoo.xml"), Path.of("src/zoo-new")); // burada da tıpkı Files.copy()'de 
										// olduğu gibi zoo-new isimli dosya oluşturur ve içine kopyalar.
		
		// StandardCopyOption.ATOMIC_MOVE // tıpkı AtomicInteger gibi çalışır. Yani tek bir işlemde dosyayı
																								// taşır.
		
		File zoo = new File("zoo");
		zoo.renameTo(new File("zoo-renamed"));
		
		
		// Files.delete() ve Files.deleteIfExists() metotlarında bir dizini silmek için dizinin boş olması 
			// gerekmektedir.
		
		Path p8 = Path.of("non-exists/missig-file.xml");
		Path p9 = Path.of("non-exists/missig-file.xml");
		
		System.out.println(p8.equals(p9)); // true
		System.out.println(Files.isSameFile(p8, p9)); // true
		
		Path p0 = Path.of("non-exists/missig-file2.xml");
		
		System.out.println(p9.equals(p0)); // false
		System.out.println(Files.isSameFile(p9, p0)); // throws exception
		
		Path p10 = Path.of("./non-exists/../missig-file.xml");
		
		System.out.println(p9.equals(p10)); // false
		System.out.println(Files.isSameFile(p9, p10)); // true
		
		System.out.println(Files.mismatch(Path.of("non-exists/missig-file.xml"), 
                              Path.of("non-exists/missig-file2.xml"))); // eğer içeriği aynıysa, -1 
																		// farklıysa farklılığın ilk 
																		// oluştuğu yerin index'ini verir.
		} 
	}
	
	public static void copyPath(Path source, Path target) {
		try {
			Files.copy(source, target);
			if (Files.isDirectory(source)) {
				try (Stream<Path> s = Files.list(source)) {
					s.forEach(p -> copyPath(p, target.resolve(p.getFileName())));
				}
			}
		} catch (IOException e) {
		}
	}
}
