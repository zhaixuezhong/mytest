package common.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

/**
 * 
 * @author weixin
 *系统数据库存放的都是 不使用向量 两次加密的密文
 */
@SuppressWarnings("restriction")
public class SecretUtils {

	/**
	 * 根据参数生成Key;
	 * 
	 * @param strKey
	 */
	private static Key getKeyBak(String strKey) {
		Key key = null;
		try {
			KeyGenerator _generator = KeyGenerator.getInstance("DES");
			_generator.init(new SecureRandom(strKey.getBytes()));
			key = _generator.generateKey();
			_generator = null;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return key;
	}

	/**
	 * 获得密钥
	 * 
	 * @param secretKey
	 * @return
	 * @throws java.security.NoSuchAlgorithmException
	 * @throws java.security.InvalidKeyException
	 * @throws java.security.spec.InvalidKeySpecException
	 */
	private static SecretKey getKey(String secretKey){

		try {
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			DESKeySpec keySpec = new DESKeySpec(secretKey.getBytes());
			keyFactory.generateSecret(keySpec);
			return keyFactory.generateSecret(keySpec);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获得一次3DES加密后的密文
	 *
	 * @param
	 * @return strMi
	 */
	private static String getEncString(String strMing, String strKey) {
		byte[] byteMi = null;
		byte[] byteMing = null;
		String strMi = "";
		Key key = getKey(strKey);
		BASE64Encoder encoder = new BASE64Encoder();
		try {
			byteMing = strMing.getBytes("utf-8");
			byteMi = getEncCode(byteMing, key);
			strMi = encoder.encode(byteMi);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			encoder = null;
			byteMi = null;
			byteMing = null;
		}
		return strMi;
	}

	/**
	 * 获得两次3DES加密后的密文
	 *
	 * @param
	 * @return strMi
	 */
	public static String getTwiceEncString(String strMing, String strKey) {
		return getEncString(getEncString(strMing, strKey), strKey);
	}

	/**
	 * 获得一次3DES解密后的明文
	 *
	 * @param
	 * @return strMing
	 */
	private static String getDecString(String strMi, String strKey) {
		BASE64Decoder base64Decoder = new BASE64Decoder();
		byte[] byteMing = null;
		byte[] byteMi = null;
		String strMing = "";
		Key key = getKey(strKey);
		try {
			byteMi = base64Decoder.decodeBuffer(strMi);
			byteMing = getDecCode(byteMi, key);
			strMing = new String(byteMing, "utf-8");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			base64Decoder = null;
			byteMing = null;
			byteMi = null;
		}
		return strMing;
	}

	/**
	 * 获得两次3DES解密后的明文
	 *
	 * @param
	 * @return strMing
	 */
	public static String getTwiceDecString(String strMi, String strKey) {
		return getDecString(getDecString(strMi, strKey), strKey);
	}

	/**
	 * 获得一次3DES加密后的密文
	 *
	 * @param byts
	 * @return
	 */
	private static  byte[]  getEncCode(byte[] byts, Key key) {
		byte[] byteFina = null;
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byteFina = cipher.doFinal(byts);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cipher = null;
		}
		return byteFina;
	}

	/**
	 * 获得一次3DES解密后的明文
	 *
	 * @param bytd
	 * @return
	 */
	private static  byte[] getDecCode(byte[] bytd, Key key) {
		byte[] byteFina = null;
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byteFina = cipher.doFinal(bytd);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cipher = null;
		}
		return byteFina;
	}
	/**
	 * 获得密钥 使用向量
	 *
	 * @param secretKey
	 * @return
	 * @throws java.security.NoSuchAlgorithmException
	 * @throws java.security.InvalidKeyException
	 * @throws java.security.spec.InvalidKeySpecException
	 */
	private static Key getKey2(String secretKey){
		
		try {
			Key deskey = null;  
			DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());  
			SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");  
			deskey = keyfactory.generateSecret(spec);
			return deskey;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 获得一次3DES加密后的密文 使用向量
	 * 
	 * @param byts
	 * @return
	 */
	private static  byte[]  getEncCode2(byte[] byts, Key key,String vector) {
		byte[] byteFina = null;
		Cipher cipher;
		try {
			 cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");  
			 IvParameterSpec ips = new IvParameterSpec(vector.getBytes());  
			 cipher.init(Cipher.ENCRYPT_MODE, key, ips);  
			 byteFina = cipher.doFinal(byts);  
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cipher = null;
		}
		return byteFina;
	}
	/**
	 * 获得一次3DES加密后的密文 使用向量
	 * 
	 * @param
	 * @return strMi
	 */
	public static String getEncString(String strMing, String strKey,String vector) {
		byte[] byteMi = null;
		byte[] byteMing = null;
		String strMi = "";
		Key key = getKey2(strKey);
		BASE64Encoder encoder = new BASE64Encoder();
		try {
			byteMing = strMing.getBytes("utf-8");
			byteMi = getEncCode2(byteMing, key,vector);
			strMi = encoder.encode(byteMi);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			encoder = null;
			byteMi = null;
			byteMing = null;
		}
		return strMi;
	}
	/**
	 * 获得两次3DES加密后的密文 使用向量
	 * 
	 * @param
	 * @return strMi
	 */
	public static String getTwiceEncString(String strMing, String strKey,String vector) {
		return getEncString(getEncString(strMing, strKey,vector), strKey,vector);
	}
	/**
	 * 获得一次3DES解密后的明文 使用向量
	 * 
	 * @param bytd
	 * @return
	 */
	private static  byte[] getDecCode(byte[] bytd, Key key,String vector) {
		byte[] byteFina = null;
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");  
			IvParameterSpec ips = new IvParameterSpec(vector.getBytes());  
			cipher.init(Cipher.DECRYPT_MODE, key,ips);
			byteFina = cipher.doFinal(bytd);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cipher = null;
		}
		return byteFina;
	}
	/**
	 * 获得一次3DES解密后的明文 使用向量
	 * 
	 * @param
	 * @return strMing
	 */
	public static String getDecString(String strMi, String strKey,String vector) {
		BASE64Decoder base64Decoder = new BASE64Decoder();
		byte[] byteMing = null;
		byte[] byteMi = null;
		String strMing = "";
		Key key = getKey2(strKey);
		try {
			byteMi = base64Decoder.decodeBuffer(strMi);
			byteMing = getDecCode(byteMi, key,vector);
			strMing = new String(byteMing, "utf-8");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			base64Decoder = null;
			byteMing = null;
			byteMi = null;
		}
		return strMing;
	}
	/**
	 * 获得两次3DES解密后的明文 使用向量
	 * 
	 * @param
	 * @return strMing
	 */
	public static String getTwiceDecString(String strMi, String strKey,String vector) {
		return getDecString(getDecString(strMi, strKey,vector), strKey,vector);
	}

}