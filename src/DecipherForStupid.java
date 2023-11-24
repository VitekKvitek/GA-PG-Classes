import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class DecipherForStupid {
    public static void main(String[] args) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        BufferedReader reader = new BufferedReader(new FileReader("key+message.txt"));
            // Read the first line
            String stringKey = reader.readLine();

            // Read the second line
            String stringMsg = reader.readLine();
        byte[] bytesKey = Base64.getDecoder().decode(stringKey);
        byte[] bytesMsg = Base64.getDecoder().decode(stringMsg);

        SecretKey key = new SecretKeySpec(bytesKey, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE,key);
        byte[] byteDecriptedMsg = cipher.doFinal(bytesMsg);
        String decryptedMsg = new String (byteDecriptedMsg);
        System.out.println(decryptedMsg);

    }
}
