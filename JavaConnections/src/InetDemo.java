import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress ip = InetAddress.getByName("www.google.com");
        System.out.println(ip.getHostName());
        System.out.println(Arrays.toString(ip.getAddress()));
    }
}
