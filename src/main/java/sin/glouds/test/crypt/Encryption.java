package sin.glouds.test.crypt;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Encryption {

	/**
	 * Base64内容传送编码
	 */
	public static final String BASE64 = "base64";
	/**
	 * Message Digest algorithm 5，消息摘要算法
	 */
	public static final String MD5 = "md5";
	/**
	 * Secure Hash Algorithm，安全散列算法
	 */
	public static final String SHA = "sha";
	/**
	 * Hash Message Authentication Code，散列消息鉴别码
	 */
	public static final String HMAC = "hmac";
	/**
	 * Data Encryption Standard，数据加密算法
	 */
	public static final String DES = "des";
	/**
	 * Password-based encryption，基于密码验证
	 */
	public static final String PBE = "pbe";
	/**
	 * 算法的名字以发明者的名字命名：Ron Rivest, AdiShamir 和Leonard Adleman
	 */
	public static final String RSA = "rsa";
	/**
	 * Diffie-Hellman算法，密钥一致协议
	 */
	public static final String DH = "dh";
	/**
	 * Digital Signature Algorithm，数字签名
	 */
	public static final String DSA = "dsa";
	/**
	 * Elliptic Curves Cryptography，椭圆曲线密码编码学
	 */
	public static final String ECC = "ecc";
	/**
	 * 
	 */
	public static final String AES = "aes";
	
	public static String encryptBASE64(byte[] key) {
		return Base64.getEncoder().encodeToString(key);
	}
	
	public static byte[] decryptBASE64(String key) throws IOException {
		return Base64.getDecoder().decode(key);
	}
	
	public static String encryptMD5(String key) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md5 = MessageDigest.getInstance("md5");
		md5.update(key.getBytes());
		return bytesToHexStr(md5.digest());
	}
	
	private static String bytesToHexStr(byte[] md) {
		char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
		int j = md.length;
		char str[] = new char[j * 2];
        int k = 0;
        for (int i = 0; i < j; i++) {
            byte byte0 = md[i];
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
            str[k++] = hexDigits[byte0 & 0xf];
        }
        return new String(str);
	}
	
	public static String encryptSHA(String src) throws NoSuchAlgorithmException {
		MessageDigest sha = MessageDigest.getInstance("sha");
		sha.update(src.getBytes());
		return bytesToHexStr(sha.digest());
	}
	
	public static String encryptHMAC(String src, String key) throws NoSuchAlgorithmException, InvalidKeyException, IOException {
		SecretKey secretKey = new SecretKeySpec(decryptBASE64(key), "hmacmd5");
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		mac.init(secretKey);
		return bytesToHexStr(mac.doFinal(src.getBytes()));
	}
	
	public static String getHMACKey() throws NoSuchAlgorithmException {
		KeyGenerator generator = KeyGenerator.getInstance("hmacmd5");
		SecretKey key = generator.generateKey();
		return encryptBASE64(key.getEncoded());
	}
	
	public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException {
//		System.out.println(encryptBASE64("asdf".getBytes()));
//		System.out.println("---------------");
//		System.out.println(new String(decryptBASE64("YXNk")));
//      System.out.println(encryptMD5("a"));
//		System.out.println(encryptSHA("a"));
//		String key = getHMACKey();
//		System.out.println(key);
//		System.out.println(bytesToHexStr(decryptBASE64(key)));
//		System.out.println(encryptHMAC("a", key));
		
		System.out.println(encryptMD5("Hezx35841"));
	}
}
