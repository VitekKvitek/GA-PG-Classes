package tretak;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
        //converts string to bytes
        byte[] bytesKey = Base64.getDecoder().decode(stringKey);
        byte[] bytesMsg = Base64.getDecoder().decode(stringMsg);

        //creates secret key
        SecretKey key = new SecretKeySpec(bytesKey, "AES");
        //create cipher obj
        Cipher cipher = Cipher.getInstance("AES");
        //initalize cipher obj
        cipher.init(Cipher.DECRYPT_MODE,key);
        //decrypts byte msg
        byte[] byteDecriptedMsg = cipher.doFinal(bytesMsg);
        String decryptedMsg = new String (byteDecriptedMsg);
        System.out.println(decryptedMsg);

    }
}
