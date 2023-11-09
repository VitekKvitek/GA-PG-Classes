import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

public class Sifruj {
    public static void main(String[] args) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Scanner sc = new Scanner(System.in);

        String zprava = sc.nextLine();

        Path jmenosouboru = Paths.get("klic.dat");
        byte[] bytekey = Files.readAllBytes(jmenosouboru);

        SecretKey key = new SecretKeySpec(bytekey, "AES");


        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] vysledek = cipher.doFinal(zprava.getBytes());

        Path jmenoSouboru2 = Paths.get("message.dat");
        Files.write(jmenoSouboru2, vysledek);


    }
}
