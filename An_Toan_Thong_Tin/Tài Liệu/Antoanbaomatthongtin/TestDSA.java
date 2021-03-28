import java.security.KeyPairGenerator;
import java.security.KeyPair;
import java.security.PublicKey;
import java.security.PrivateKey;
import java.security.Signature;
import java.io.FileInputStream;
import java.util.*; 

public class TestDSA {
  private static byte[] sign(String datafile, PrivateKey prvKey,
      String sigAlg) throws Exception {
    Signature sig = Signature.getInstance(sigAlg);
    sig.initSign(prvKey);
    FileInputStream fis = new FileInputStream(datafile);
    byte[] dataBytes = new byte[1024];
    int nread = fis.read(dataBytes);
    while (nread > 0) {
      sig.update(dataBytes, 0, nread);
      nread = fis.read(dataBytes);
    };
    return sig.sign();
  }
  private static boolean verify(String datafile, PublicKey pubKey,
      String sigAlg, byte[] sigbytes) throws Exception {
    Signature sig = Signature.getInstance(sigAlg);
    sig.initVerify(pubKey);
    FileInputStream fis = new FileInputStream(datafile);
    byte[] dataBytes = new byte[1024];
    int nread = fis.read(dataBytes);
    while (nread > 0) {
      sig.update(dataBytes, 0, nread);
      nread = fis.read(dataBytes);
    };
    return sig.verify(sigbytes);
  }
  public static void main(String[] unused) throws Exception {
    // Generate a key-pair
    KeyPairGenerator kpg = KeyPairGenerator.getInstance("DSA");
    kpg.initialize(512); // 512 is the keysize.
    KeyPair kp = kpg.generateKeyPair();
    PublicKey pubk = kp.getPublic();
    PrivateKey prvk = kp.getPrivate();

    String datafile = "SignatureTest.java";
    byte[] sigbytes = sign(datafile, prvk, "SHAwithDSA");
    System.out.println("Signature(in hex):: " +
    //    Util.byteArray2Hex(sigbytes));
        Base64.getEncoder() 
                  .encodeToString(sigbytes));

    boolean result = verify(datafile, pubk, "SHAwithDSA", sigbytes);
    System.out.println("Signature Verification Result = " + result);
  }
}
