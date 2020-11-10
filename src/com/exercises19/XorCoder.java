package com.exercises19;

/**
 * @author Алексей
 * @version 1
 * Public class contains static methods for xor decoding
 */
@Encription(encriptionType = "xor",version = 1)
public class XorCoder {

    /**
     * Encode method String to byte[] private%static
     * @param base - String to encode
     * @param keystr - String to encode with
     * @return - byte[] returned after encoding
     */
    public static byte[] encode(String base, String keystr) {
        byte[] baseaRrr = base.getBytes();
        byte[] key = keystr.getBytes();
        byte[] res = new byte[baseaRrr.length];
        for (int i = 0; i < baseaRrr.length; i++) {
            res[i] = (byte) (baseaRrr[i] ^ key[i % key.length]);
        }
        return res;
    }

    /**
     *  Encode method byte[] to byte[] private%static
     * @param base - byte[] reto encode
     * @param keystr - String to encode with
     * @return - byte[] returned after encoding
     */
    public static byte[] encode(byte[] base, String keystr) {
        byte[] baseaRrr = base;
        byte[] key = keystr.getBytes();
        byte[] res = new byte[baseaRrr.length];
        for (int i = 0; i < baseaRrr.length; i++) {
            res[i] = (byte) (baseaRrr[i] ^ key[i % key.length]);
        }
        return res;
    }

    /**
     * Decode method private%static
     * @param coded - byte[] which is supposed to be decoded
     * @param keystr - String containing xor key
     * @return - byte[] resulted
     */
    public static byte[] decode(byte[] coded, String keystr) {
        byte[] key = keystr.getBytes();
        byte[] res = new byte[coded.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = (byte) (coded[i] ^ key[i % key.length]);
        }
        return res;
    }
}


