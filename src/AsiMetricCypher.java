import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Scanner;

public class AsiMetricCypher {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        Path publicKeyFile = Paths.get("publicKey.dat");
        byte[] bytePublicKey = Files.readAllBytes(publicKeyFile);

        X509EncodedKeySpec bobPubKeySpec = new X509EncodedKeySpec(bytePublicKey);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(bobPubKeySpec);

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.PUBLIC_KEY, publicKey);
        byte[] encryptedInput = cipher.doFinal(input.getBytes());
        Path messageFile = Paths.get("message.dat");
        Files.write(messageFile, encryptedInput);

    }
}
