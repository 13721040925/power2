package cn.util;

import java.math.BigInteger;
import java.security.MessageDigest;

import net.iharder.Base64;

//MD5加密工具类
public final class MD5Util {
	private MD5Util() {
	}

	// 加密方法
	public static String enconding(String msg) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			// 计算md5函数
			md.update(msg.getBytes());
			// digest()最后确定返回md5 hash值，返回值为8位字符串。
			// 因为md5 hash值是16位的hex值，实际上就是8位的字符
			// BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；
			// 得到字符串形式的hash值转大写
			return new BigInteger(1, md.digest()).toString(16).toUpperCase();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(enconding("admin123"));
	}

	/**
	 * BASE64的加密算法
	 * 
	 * @param target要加密的字符串
	 * @return String加密后的字符串
	 */
	public static String encryptBASE64(String target) {
		return Base64.encodeBytes(target.getBytes());
	}

	/**
	 * BASE64的解密算法
	 * 
	 * @param target要解密的字符串
	 * @return String解密后的字符串
	 */
	public static String decryptBASE64(String target) {
		try {
			return new String(Base64.decode(target), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
