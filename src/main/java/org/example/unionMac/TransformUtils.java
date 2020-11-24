package org.example.unionMac;

import java.io.UnsupportedEncodingException;

public class TransformUtils {


    public static String stringToHexString(String str, String encoding) {
        try {

            if (null == encoding) {
                return bytesToHexString(str.getBytes(), 32, "00");
            }

            return bytesToHexString(str.getBytes(encoding), 32, "00");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String bytesToHexString(byte[] bytes) {
        return bytesToHexString(bytes, 0, null);
    }

    /**
     * 字节数组转化为十六进制字符串 并按照len的倍数进行补"0"
     *
     * @param bytes 字节数据
     * @param len   补位原则
     * @return
     */
    public static String bytesToHexString(byte[] bytes, int len, String cover) {
        StringBuffer hexStr = new StringBuffer();
        for (byte b : bytes) {
            hexStr.append(String.format("%02x", new Integer(b & 0xff)));
        }

        if (len != 0) {
            while (hexStr.length() % len != 0) {
                hexStr.append(cover);
            }
        }

        return hexStr.toString();
    }

    /**
     * 将字符串str 按照长度len 进行分组
     *
     * @param str 字符串
     * @param len 每组字符长度
     * @return
     */
    public static String[] dataGrouping(String str, int len) {
        int lenth = str.length() % len == 0 ? str.length() / len : str.length() / len + 1;
        String[] data = new String[lenth];
        for (int i = 0; i < lenth; i++) {
            data[i] = str.substring(i * len, i * len + len);
        }
        return data;
    }

    /**
     * 加密，异或运算
     *
     * @param strs
     * @return
     */
    public static String handleXOrStringArr(String[] strs) {
        String result = "";
        for (int i = 1; i < strs.length; i++) {
            byte[] bytes = new byte[16];
            if (i == 1) {
                bytes = bytesXOR(hexStringToByteArr(strs[0]), hexStringToByteArr(strs[1]));
            } else {
                bytes = bytesXOR(hexStringToByteArr(strs[i]), hexStringToByteArr(result));
            }
            result = bytesToHexString(bytes);
        }
        return result.toUpperCase();
    }

    /**
     * 字节数组异或
     *
     * @param src1
     * @param src2
     * @return
     */
    public static byte[] bytesXOR(byte[] src1, byte[] src2) {
        int length = src1.length;
        if (length != src2.length) {
            return null;
        }
        byte[] result = new byte[length];
        for (int i = 0; i < length; i++) {
            result[i] = byteXOR(src1[i], src2[i]);
        }
        return result;
    }


    /**
     * 单字节异或
     *
     * @param src1
     * @param src2
     * @return
     */
    public static byte byteXOR(byte src1, byte src2) {
        return (byte) ((src1 & 0xFF) ^ (src2 & 0xFF));
    }

    /**
     * convert hexstring to byte array
     *
     * @param str
     * @return
     */
    public static byte[] hexStringToByteArr(String str) {
        if (str == null || str.trim().equals("")) {
            return new byte[0];
        }

        byte[] bytes = new byte[str.length() / 2];
        for (int i = 0; i < str.length() / 2; i++) {
            String subStr = str.substring(i * 2, i * 2 + 2);
            bytes[i] = (byte) Integer.parseInt(subStr, 16);
        }

        return bytes;
    }

    /**
     * 十六进制转字符串
     *
     * @param hexStr
     * @return
     */
    public static String hexStr2Str(String hexStr) {
        String str = "0123456789ABCDEF";
        char[] hexs = hexStr.toCharArray();
        byte[] bytes = new byte[hexStr.length() / 2];
        int n;
        for (int i = 0; i < bytes.length; i++) {
            n = str.indexOf(hexs[2 * i]) * 16;
            n += str.indexOf(hexs[2 * i + 1]);
            bytes[i] = (byte) (n & 0xff);
        }
        return new String(bytes);
    }
}