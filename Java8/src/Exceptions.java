import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class Exceptions {
	public static void main(String[] args) {
		// Legal
		try {			
		} catch (Exception e) {
		}
		
		// Illegal çünkü FileNotFoundException IS-A IOException
		//try {
		//} catch (FileNotFoundException | IOException e) {
		//}
		
		// Illegal
		//try {
		//} catch (SQLException e) {
		//}
		
		// Suppress Exception: İlk önce try bloğundaki exception baz alınır. Diğer exception bastırılır. 
		try (Computer computer = new Computer()){
			throw new IllegalArgumentException("Hob");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

class Computer implements Closeable {

	@Override
	public void close() throws IOException {
		System.out.println("Shut down.");
		throw new IOException("Computer is not found.");
	}
	
}

// throws keyword'ü kaltıldığı zaman genelden özele gider. 
// Yani Exception -> IOException -> FileNotFoundException -> void şeklinde olabilir.
interface Test {
	public void th() throws Exception;
}

interface SubTest extends Test {
	 @Override
	 public void th() throws IOException;
}