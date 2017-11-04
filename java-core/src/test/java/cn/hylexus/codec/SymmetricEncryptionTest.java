package cn.hylexus.codec;

import cn.hylexus.utils.HexStringUtils;
import org.junit.Assert;
import org.junit.Test;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

/**
 * 对称加密算法测试
 *
 * @author hylexus
 * createdAt 2017/11/4
 **/
public class SymmetricEncryptionTest {

    private static final String KEY_DES = "DES";

    public static final String plaintext = "bug频频日复日，需求连连年复年。";
    public static final String password = "12345678";

    private byte[] desCodec(byte[] data, byte[] key, int mode) throws Exception {
        SecureRandom sr = new SecureRandom();
        DESKeySpec dks = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_DES);
        SecretKey secretkey = keyFactory.generateSecret(dks);
        //创建Cipher对象
        Cipher cipher = Cipher.getInstance(KEY_DES);
        //初始化Cipher对象
        cipher.init(mode, secretkey, sr);
        //加解密
        return cipher.doFinal(data);
    }

    @Test
    public void testEncodeByDES() throws Exception {
        // 加密
        byte[] bytes = desCodec(plaintext.getBytes(), password.getBytes(), Cipher.ENCRYPT_MODE);
        System.out.println(HexStringUtils.bytesToHex2(bytes));

        // 解密
        byte[] bytes1 = desCodec(bytes, password.getBytes(), Cipher.DECRYPT_MODE);
        Assert.assertEquals(plaintext, new String(bytes1));
    }
}
