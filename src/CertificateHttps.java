import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.Certificate;

public class CertificateHttps {
    public static void main(String[] args) throws IOException {
        URL destinationURL = new URL("https://gyarab.ddns.net");
        HttpsURLConnection conn = (HttpsURLConnection) destinationURL.openConnection();
        conn.connect();
        Certificate[] certs = conn.getServerCertificates();

        System.out.println("Pocet certifikatu:" + certs.length);
        System.out.println(certs[0]);


    }
}
