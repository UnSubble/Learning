import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class URLDemo {
    public static void main(String[] args) throws IOException {
        String rawFormatURL = "https://jsonapi.org/examples/";
        URL url = new URL(rawFormatURL);
        System.out.println(url.getProtocol());
        System.out.println(url.getAuthority());
        System.out.println(url.getHost());
        System.out.println(url.getPort());
        System.out.println(url.getPath());
        System.out.println(url.getFile());
        System.out.println(url.getRef());

        System.out.println("-----------------------------");

        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        while ((line = reader.readLine()) != null)
            System.out.println(line);
        reader.close();
    }
}