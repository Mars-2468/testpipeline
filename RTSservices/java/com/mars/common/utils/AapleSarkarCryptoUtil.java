package com.mars.common.utils;

import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AapleSarkarCryptoUtil {

	String clientCode = "NMCDeptN";
	String checkSumkey = "GNGMCA8v3G7M";
	String Department = "NGMCN";
	String clientEncryptKey = "@pn@NGM@m@h@0nl!ne@30308";
	String clientEncryptIV  = "NGM@01@6";
	
    public static String simpleTripleDes(String Data, String strKey, String striv) {
        try {
            byte[] key = strKey.getBytes(StandardCharsets.UTF_8);
            byte[] iv = striv.getBytes(StandardCharsets.UTF_8);
            byte[] data = Data.getBytes(StandardCharsets.UTF_8);

            Cipher cipher = Cipher.getInstance("DESede/CBC/NoPadding");
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "DESede");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

            byte[] paddedData = padZeros(data, 8);
            byte[] enc = cipher.doFinal(paddedData);

            return bytesToHex(enc);

        } catch (Exception e) {
            throw new RuntimeException("Encryption error", e);
        }
    }

    private static byte[] padZeros(byte[] source, int blockSize) {
        int paddedSize = ((source.length + blockSize - 1) / blockSize) * blockSize;
        byte[] padded = new byte[paddedSize];
        System.arraycopy(source, 0, padded, 0, source.length);
        return padded;
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) sb.append('0');
            sb.append(hex);
        }
        return sb.toString();
    }
}
