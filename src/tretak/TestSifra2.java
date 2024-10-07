package tretak;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.Objects;
import java.util.Scanner;

public class TestSifra2 {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        StringBuilder key = new StringBuilder();
        StringBuilder msg = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        String inputLine;
        while (!Objects.equals(inputLine = sc.nextLine(), "")){
            key.append(inputLine);
        }
        try {
            while (!Objects.equals(inputLine = sc.nextLine(), "")){
                msg.append(inputLine);
            }
        }catch (Exception ignored) {
        }


        byte[] bytesKey = Base64.getDecoder().decode(key.toString());
        byte[] bytesMsg = Base64.getDecoder().decode(msg.toString());

        PKCS8EncodedKeySpec bobPubKeySpec = new PKCS8EncodedKeySpec(bytesKey);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(bobPubKeySpec);

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE,privateKey);
        byte[] byteDecriptedMsg = cipher.doFinal(bytesMsg);

        String decryptedMsg = new String (byteDecriptedMsg);
        System.out.println(decryptedMsg);
    }
}
