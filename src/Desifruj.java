import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Desifruj {
    public static void main(String[] args) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        Path jmenosouboru = Paths.get("mujklic.dat");
        byte[] bytekey = Files.readAllBytes(jmenosouboru);
        SecretKey key = new SecretKeySpec(bytekey, "AES");

        Path jmenosouboru2 = Paths.get("message.dat");
        byte[] cipheredmessage = Files.readAllBytes(jmenosouboru2);

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] vysledek = cipher.doFinal(cipheredmessage);

        String decriptedText = new String (vysledek);
        System.out.println(decriptedText);


    }
}
