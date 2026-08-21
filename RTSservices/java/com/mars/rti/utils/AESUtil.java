package com.mars.rti.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESUtil {

    // Must be exactly 16 characters for AES-128
    private static final String SECRET_KEY = "MarsRTS123456789";

    private static final String ALGORITHM = "AES";

    public static String encrypt(String value) throws Exception {
        SecretKeySpec key = new SecretKeySpec(
                SECRET_KEY.getBytes(StandardCharsets.UTF_8),
                ALGORITHM);

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] encrypted = cipher.doFinal(value.getBytes(StandardCharsets.UTF_8));

        return Base64.getUrlEncoder().encodeToString(encrypted);
    }

    public static String decrypt(String encryptedValue) throws Exception {

        SecretKeySpec key = new SecretKeySpec(
                SECRET_KEY.getBytes(StandardCharsets.UTF_8),
                ALGORITHM);

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] decoded = Base64.getUrlDecoder().decode(encryptedValue);

        return new String(cipher.doFinal(decoded), StandardCharsets.UTF_8);
    }
}