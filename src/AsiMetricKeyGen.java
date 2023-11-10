import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.*;

public class AsiMetricKeyGen {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(512);
        KeyPair keyPair = keyGen.generateKeyPair();

        PrivateKey privateKey = keyPair.getPrivate();
        byte[] bytePrivateKey = privateKey.getEncoded();
        Path filePrivateKey = Paths.get("privateKey.dat");
        Files.write(filePrivateKey,bytePrivateKey);

        PublicKey publicKey = keyPair.getPublic();
        Path filePublicKey = Paths.get("publicKey.dat");
        byte[] bytePublicKey = privateKey.getEncoded();
        Files.write(filePublicKey,bytePublicKey);

        System.out.println(privateKey);
    }
}
