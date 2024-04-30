import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        Socket socket = server.accept();
        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader reader = new BufferedReader(inputStreamReader);

        String line = reader.readLine();

        if (line != null) {
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("SUCCESS".getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
            System.out.println("MSG: " + line);
        }

        reader.close();
        inputStreamReader.close();
        socket.close();
    }
}
