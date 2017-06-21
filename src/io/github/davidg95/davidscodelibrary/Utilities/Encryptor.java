/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.davidg95.davidscodelibrary.Utilities;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 * Class which deals with the encryption of data.
 *
 * @author David
 * @param <T> the Type of object this Encryptor will be used for
 */
public class Encryptor<T> {

    /**
     * The default encryption key.
     */
    private static final String DEFAULT_KEY = "jtillencryptkey1";

    /**
     * They key to be used.
     */
    private final String key;

    /**
     * Returns a new instance of the Encryptor object.
     *
     * @param key the key to use. Will be padded or reduced to 16 characters.
     * @return the Encryptor object.
     */
    public static Encryptor getEncryptor(String key) {
        if (key.length() < 16) {
            while (key.length() != 16) {
                key = key + " ";
            }
        } else if (key.length() > 16) {
            key = key.substring(0, 16);
        }
        return new Encryptor<>(key);
    }

    /**
     * Returns a new instance of the the Encryptor object using the default key.
     *
     * @return the Encryptor object.
     */
    public static Encryptor getEncryptor() {
        return new Encryptor<>(DEFAULT_KEY);
    }

    public Encryptor(String key) {
        this.key = key;
    }

    /**
     * Method to encrypt an object. This method uses reflection to scan all
     * fields in an object and encrypt them. Only fields that are String are
     * encrypted by this method.
     *
     * @param o the object to encrypt.
     * @return the encrypted object.
     */
    public T encrypt(T o) {
        Class cls = o.getClass();
        for (Field f : cls.getDeclaredFields()) {
            f.setAccessible(true);
            if (f.getType().toString().equals("class java.lang.String")) {
                try {
                    String s = (String) f.get(o);
                    s = encrypt(s);
                    f.set(o, s);
                } catch (IllegalArgumentException | IllegalAccessException ex) {
                    Logger.getLogger(Encryptor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return o;
    }

    /**
     * Method to decrypt an object. This method uses reflection to scan all
     * fields in an object and decrypt them. Only fields that are Strings are
     * decrypted by this.
     *
     * @param o the object to decrypt.
     * @return the decrypted object.
     */
    public T decrypt(T o) {
        Class cls = o.getClass();
        for (Field f : cls.getDeclaredFields()) {
            f.setAccessible(true);
            if (f.getType().toString().equals("class java.lang.String")) {
                try {
                    String s = (String) f.get(o);
                    s = decrypt(s);
                    f.set(o, s);
                } catch (IllegalArgumentException | IllegalAccessException ex) {
                    Logger.getLogger(Encryptor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return o;
    }

    /**
     * Method to encrypt a String.
     *
     * @param text the String to encrypt.
     * @return the encrypted String.
     */
    public String encrypt(String text) {
        try {
            byte[] encryptedBytes = encrypt(text.getBytes("UTF8"));

            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Encryptor.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Method to decrypt a String.
     *
     * @param text the String to decrypt.
     * @return if decrypted String.
     */
    public String decrypt(String text) {
        try {
            byte[] cipherText = Base64.getDecoder().decode(text);
            byte[] plainTextInBytes = decrypt(cipherText);
            return new String(plainTextInBytes, "UTF8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Encryptor.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Method to encrypt a byte array.
     *
     * @param plain the byte array to encrypt.
     * @return the encrypted byte array.
     */
    public byte[] encrypt(byte[] plain) {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            byte[] raw = cipher.doFinal(plain);
            return raw;
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(Encryptor.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Method to decrypt a byte array.
     *
     * @param cipherText the byte array to decrypt.
     * @return the decrypted byte array.
     */
    public byte[] decrypt(byte[] cipherText) {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, keySpec);

            byte[] plainText = cipher.doFinal(cipherText);
            return plainText;
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(Encryptor.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
