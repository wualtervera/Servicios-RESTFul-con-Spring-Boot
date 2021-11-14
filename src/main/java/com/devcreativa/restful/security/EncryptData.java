package com.devcreativa.restful.security;

import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptData {

	public EncryptData() {
	}

	private static final String SECRET_KEY = "WBtPWrFCdJtZCCjbEYHcFMESMMuhxVJf";
	private static final String SALT = "zeUkjWAedyZNSsRJrAnPQWSNmsegnfXh";

	public static String AESencrypt(String strToEncrypt) {
		try {
			byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			IvParameterSpec ivspec = new IvParameterSpec(iv);

			SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			KeySpec keyspec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT.getBytes(), 65536, 256);
			SecretKey secretkey = keyfactory.generateSecret(keyspec);
			SecretKeySpec secretkeySpec = new SecretKeySpec(secretkey.getEncoded(), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretkeySpec, ivspec);
			return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
			
		} catch (Exception e) {
			System.out.println("Error de encriptación: " + e.toString());
		}
		return null;
	}

	public static String AESdecrypt(String strToDecrypt) {
		try {
			byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			IvParameterSpec ivspec = new IvParameterSpec(iv);

			SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			KeySpec keyspec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT.getBytes(), 65536, 256);
			SecretKey secretkey = keyfactory.generateSecret(keyspec);
			SecretKeySpec secretkeySpec = new SecretKeySpec(secretkey.getEncoded(), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, secretkeySpec, ivspec);
			return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		} catch (Exception e) {
			System.out.println("Error de desencripatación: " + e.toString());
		}
		return null;
	}

	// https://howtodoinjava.com/java/java-security/aes-256-encryption-decryption/

}
