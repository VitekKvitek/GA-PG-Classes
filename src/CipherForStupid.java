import javax.crypto.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class CipherForStupid {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException {
        String message = "cokolada fuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuj";
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey key = keyGenerator.generateKey();

        byte[] messageInBytes = message.getBytes();

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] cipheredMSG = cipher.doFinal(messageInBytes);
        byte[] bytekey = key.getEncoded();

        String stringKey = Base64.getEncoder().encodeToString(bytekey);
        String stringMessage = Base64.getEncoder().encodeToString(cipheredMSG);

        Path filename = Paths.get("key+message.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter("key+message.txt"));
        writer.write(stringKey);
        writer.newLine();
        writer.write(stringMessage);
        writer.close();

    }
}
