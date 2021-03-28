import java.util.*;  
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
 
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

 
public class EncryptDecryptStringWithAES {
 
    private static Cipher ecipher;
    private static Cipher dcipher;
 
    private static SecretKey key;
 
    public static void main(String[] args) {
 
        try {
 
            // generate secret key using DES algorithm
            key = KeyGenerator.getInstance("AES").generateKey();
 
            ecipher = Cipher.getInstance("AES");
            dcipher = Cipher.getInstance("AES");
 
            // initialize the ciphers with the given key
 
  ecipher.init(Cipher.ENCRYPT_MODE, key);
 
  dcipher.init(Cipher.DECRYPT_MODE, key);
 
  String encrypted = encrypt("This is a classified message!");
  System.out.println("Encrypted: " + encrypted);
 
  String decrypted = decrypt(encrypted);
 
  System.out.println("Decrypted: " + decrypted);
 
        }
        catch (NoSuchAlgorithmException e) {
            System.out.println("No Such Algorithm:" + e.getMessage());
            return;
        }
        catch (NoSuchPaddingException e) {
            System.out.println("No Such Padding:" + e.getMessage());
            return;
        }
        catch (InvalidKeyException e) {
            System.out.println("Invalid Key:" + e.getMessage());
            return;
        }
 
    }
 
    public static String encrypt(String str) {
 
  try {
 
    // encode the string into a sequence of bytes using the named charset
 
    // storing the result into a new byte array. 
 
    byte[] utf8 = str.getBytes("UTF8");
 
    byte[] enc = ecipher.doFinal(utf8);
    String test;
 
// encode to base64
 
//enc = BASE64EncoderStream.encode(enc);
    test = Base64.getEncoder() 
                  .encodeToString(enc);
 return test;
//return new String(enc);
 
  }
 
  catch (Exception e) {
 
    e.printStackTrace();
 
  }
 
  return null;

  
  
    }
 
    public static String decrypt(String str) {
 
  try {
 
    // decode with base64 to get bytes
 
//byte[] dec = BASE64DecoderStream.decode(str.getBytes());

    byte [] dec = Base64.getDecoder() 
                                .decode(str.getBytes());  
    byte[] utf8 = dcipher.doFinal(dec);
 
// create new string based on the specified charset
 
return new String(utf8, "UTF8");
 
  }
 
  catch (Exception e) {
 
    e.printStackTrace();
 
  }
 
  return null;
 
    }
 
}
