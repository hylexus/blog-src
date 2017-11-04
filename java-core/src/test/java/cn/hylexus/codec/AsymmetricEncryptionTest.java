package cn.hylexus.codec;

import cn.hylexus.utils.HexStringUtils;
import org.junit.Assert;
import org.junit.Test;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * 非对称加密算法测试
 *
 * @author hylexus
 * createdAt 2017/11/4
 **/
public class AsymmetricEncryptionTest {

    public static final String KEY_RSA = "RSA";
    public static final String plaintext = "bug频频日复日，需求连连年复年。";

    @Test
    public void testKeyGenerator() throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance(KEY_RSA);
        generator.initialize(512);
        KeyPair keyPair = generator.generateKeyPair();
        // 私钥
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        // 输出私钥
        System.out.println(new String(Base64.getEncoder().encode(privateKey.getEncoded())));
        System.out.println(new String(Base64.getEncoder().encode(publicKey.getEncoded())));
    }

    @Test
    public void testRsa() throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance(KEY_RSA);
        generator.initialize(512);
        KeyPair keyPair = generator.generateKeyPair();
        byte[] encryptBytes = encrypt(plaintext.getBytes(), keyPair.getPublic());
        System.out.println(HexStringUtils.bytesToHex2(encryptBytes));

        byte[] decryptBytes = decrypt(encryptBytes, keyPair.getPrivate());

        Assert.assertEquals(plaintext, new String(decryptBytes));
    }

    //公钥加密
    public static byte[] encrypt(byte[] content, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(content);
    }

    //私钥解密
    public static byte[] decrypt(byte[] content, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(content);
    }

    //将base64编码后的公钥字符串转成PublicKey实例
    public static PublicKey getPublicKey(String publicKey) throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(publicKey.getBytes());
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }

    //将base64编码后的私钥字符串转成PrivateKey实例
    public static PrivateKey getPrivateKey(String privateKey) throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(privateKey.getBytes());
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keySpec);
    }
}
