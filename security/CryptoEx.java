package org.example.security;

import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidParameterSpecException;
import java.util.Arrays;

/**
 * @author dragos.cosmin
 **/
public class CryptoEx {
    public static void main(String[] args) {
        String text = "Value that requires encryption";
        try {
            SecretKey key = KeyGenerator.getInstance("AES").generateKey();
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] value=text.getBytes();
            byte[] encryptedValue= cipher.doFinal(value);
//            System.out.println(Arrays.toString(value));
            System.out.println("Original value:");
            System.out.println(new String(value));
//            System.out.println(Arrays.toString(encryptedValue));
            System.out.println("Encrypted value:");
            System.out.println(new String(encryptedValue));
            GCMParameterSpec ps=cipher.getParameters().getParameterSpec(GCMParameterSpec.class);
            cipher.init(Cipher.DECRYPT_MODE,key,ps);
            byte[] decryptedValue= cipher.doFinal(encryptedValue);
            System.out.println("Decrypted value:");
            System.out.println(new String(decryptedValue));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException |
                 InvalidKeyException | IllegalBlockSizeException |
                 BadPaddingException | InvalidParameterSpecException |
                 InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }



    }
}
