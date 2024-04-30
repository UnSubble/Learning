import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 4444);
        OutputStream out = socket.getOutputStream();
        out.write("IMPORTANT MESSAGE\n".getBytes(StandardCharsets.UTF_8));
        out.flush();
        InputStream stream = socket.getInputStream();
        System.out.println("SERVER MSG: " + new String(stream.readAllBytes()));
        socket.close();
    }
}
