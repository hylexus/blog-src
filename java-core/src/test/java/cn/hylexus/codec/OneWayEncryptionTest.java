package cn.hylexus.codec;

import org.junit.Assert;
import org.junit.Test;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Arrays;
import java.util.Base64;
import java.util.zip.CRC32;

import static cn.hylexus.utils.HexStringUtils.bytesToHex2;
import static cn.hylexus.utils.HexStringUtils.bytesToHex3;
import static cn.hylexus.utils.HexStringUtils.bytesToHexString;

/**
 * 单向加密算法测试
 *
 * @author hylexus
 * createdAt 2017/11/4
 **/
public class OneWayEncryptionTest {

    public static final String plaintext = "bug频频日复日，需求连连年复年。";
    public static final Charset utf_8 = Charset.forName("UTF-8");

    /**
     * Base64编码
     */
    @Test
    public void testBase64Encode() {
        byte[] bytes = Base64.getEncoder().encode(plaintext.getBytes());
        System.out.println(new String(bytes));
    }

    /**
     * Base64解码
     */
    @Test
    public void testBase64Decode() {
        String in = "YnVn6aKR6aKR5pel5aSN5pel77yM6ZyA5rGC6L+e6L+e5bm05aSN5bm044CC";
        final Base64.Decoder decoder = Base64.getDecoder();
        byte[] bytes = decoder.decode(in.getBytes());
        byte[] bytes1 = decoder.decode(in);
        Assert.assertEquals(new String(bytes), new String(bytes1));
        Assert.assertEquals(plaintext, new String(bytes));
    }

    @Test
    public void listProviderProps() {
        // 列出已经安装/支持的Provider
        Arrays.stream(Security.getProviders()).forEach(p -> {
            System.out.println(p.getName());
            p.getServices().forEach(service -> {
                System.out.println("\t" + service.getAlgorithm());
            });
        });
    }

    @Test
    public void testMD5() throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(plaintext.getBytes(utf_8));
        byte[] bytes = messageDigest.digest();

        byte[] bytes1 = messageDigest.digest(plaintext.getBytes(utf_8));
        String out = bytesToHex3(bytes);
        String out1 = bytesToHex3(bytes1);
        Assert.assertEquals(out, out1);
        System.out.println(out);
    }

    @Test
    public void testSha1() throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA");
        byte[] bytes = digest.digest(plaintext.getBytes(utf_8));
        System.out.println(bytesToHexString(bytes));
    }

    @Test
    public void test1() throws NoSuchAlgorithmException, InvalidKeyException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HMACSHA384");

        SecretKey key = keyGenerator.generateKey();
        Mac mac = Mac.getInstance(key.getAlgorithm());
        mac.init(key);

        byte[] bytes = mac.doFinal(plaintext.getBytes());
        String out = bytesToHex2(bytes);
        System.out.println(out);
        System.out.println(out.length());
    }

    @Test
    public void testCRC32() {
        CRC32 crc32 = new CRC32();
        crc32.update(plaintext.getBytes());
        long value = crc32.getValue();
        System.out.println(value);
    }

}
