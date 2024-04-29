import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketProgramming {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(6666);
        Socket socket = ss.accept();
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        String str = inputStream.readUTF();
        inputStream.close();
        ss.close();
    }
}

class Client {
    public void connect() throws IOException {
        Socket socket = new Socket("localhost", 6666);
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        outputStream.writeUTF("hi");
        outputStream.flush();
        outputStream.close();
        socket.close();
    }
}

