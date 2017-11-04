package cn.hylexus.utils;

import java.math.BigInteger;

/**
 * @author hylexus
 * createdAt 2017/11/4
 **/
public class HexStringUtils {

    public static String bytesToHex3(byte[] md5Array) {

        StringBuilder sb = new StringBuilder();
        for (byte e : md5Array) {
            sb.append(String.format("%02x", e & 0xFF));
        }
        return sb.toString();
    }

    public static String bytesToHex2(byte[] md5Array) {
        BigInteger bigInt = new BigInteger(1, md5Array);
        return bigInt.toString(16);
    }

    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (byte e : src) {
            String hexString = Integer.toHexString(e & 0xFF);
            if (hexString.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hexString);
        }
        return stringBuilder.toString();
    }
}
