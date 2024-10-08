package tretak;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

public class GenerujKlic {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {

        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey key = keyGenerator.generateKey();

        byte[] bytekey = key.getEncoded();

        Path jmenoSouboru = Paths.get("klic.dat");
        Files.write(jmenoSouboru, bytekey);

    }
}