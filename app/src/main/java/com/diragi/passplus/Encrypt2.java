package com.diragi.passplus;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import android.os.Build;
import android.util.Base64;
import android.util.Log;

public class Encrypt2 {

    private String charsetName = "UTF8";
    private String algorithm = "DES";
    private int base64Mode = Base64.DEFAULT;

    public String getCharsetName() {
        return charsetName;
    }

    public void setCharsetName(String charsetName) {
        this.charsetName = charsetName;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public int getBase64Mode() {
        return base64Mode;
    }

    public void setBase64Mode(int base64Mode) {
        this.base64Mode = base64Mode;
    }

    public String encrypt(String key, String data) {
        if (key == null || data == null)
            return null;
        try {
            Log.d("encrypt: ", "notnull");
            DESKeySpec desKeySpec = new DESKeySpec(key.getBytes(charsetName));
            Log.d("encrypt", "1");
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(algorithm);
            Log.d("encrypt", "2");
            SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);
            Log.d("encrypt", "3");
            byte[] dataBytes = data.getBytes(charsetName);
            Log.d("encrypt", "4");
            Cipher cipher = Cipher.getInstance(algorithm);
            Log.d("encrypt", "5");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            Log.d("encrypt", "6");
            return Base64.encodeToString(cipher.doFinal(dataBytes), base64Mode);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Exception: ", "exception is: " +e, e);
            return null;
        }
    }

    public String decrypt(String key, String data) {
        if (key == null || data == null)
            return null;
        try {
            byte[] dataBytes = Base64.decode(data, base64Mode);
            DESKeySpec desKeySpec = new DESKeySpec(key.getBytes(charsetName));
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(algorithm);
            SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] dataBytesDecrypted = (cipher.doFinal(dataBytes));
            return new String(dataBytesDecrypted);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}