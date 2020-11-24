package org.example.unionMac;

import lombok.extern.slf4j.Slf4j;

/**
 * pos终端mac
 */
@Slf4j
public class MacUtil {

    public static String calMac(String key, String data) throws Exception {

            byte[] keyByte = TransformUtils.hexStringToByteArr(key);
            //补位
            String hexData = TransformUtils.stringToHexString(data, "gb2312");
            //分组
            String[] dataGroup = TransformUtils.dataGrouping(hexData, 32);
            //异或计算
            String result = TransformUtils.handleXOrStringArr(dataGroup);
            //32个HEXDECIMAL
            byte[] bytes = result.getBytes();

            //前16字节加密
            byte[] front = new byte[16];
            System.arraycopy(bytes, 0, front, 0, 16);
            byte[] encodeByte = Sm4Util.encrypt_Ecb_NoPadding(keyByte, front);

            //与后16字节异或
            byte[] behind = new byte[16];
            System.arraycopy(bytes, 16, behind, 0, 16);
            byte[] resultXOR = TransformUtils.bytesXOR(encodeByte, behind);

            //加密
            byte[] encodeByte2 = Sm4Util.encrypt_Ecb_NoPadding(keyByte, resultXOR);
            byte[] resultByte = TransformUtils.bytesToHexString(encodeByte2).getBytes();
            String ret = TransformUtils.bytesToHexString(resultByte);
            String retStr = ret.substring(0, 32).toUpperCase();
            return TransformUtils.hexStr2Str(retStr).toUpperCase();
    }

        public static void main(String[] args) throws Exception {
                String mac = calMac("0123456789ABCDEFFEDCBA9876543210", "{nihaonihaonihaonihaonihaonihao}");
                System.out.println(mac);


                /**
                 * 补位后的MAB（16进制）：
                 * 7B6E6968 616F6E69 68616F6E 6968616F 6E696861 6F6E6968 616F6E69 68616F7D
                 *
                 * 第 0组明文：       7B6E6968 616F6E69 68616F6E 6968616F
                 * 第1组明文：        6E696861 6F6E6968 616F6E69 68616F7D
                 * 与第0组密文异或：  15070109 0E010701 090E0107 01090E12
                 * 32个HEXDECIMAL：   31353037 30313039 30453031 30373031 30393045 30313037 30313039 30453132
                 * 前16字节加密结果：  B3A87D53 C5A5F6A1 CC2C9C3C 32511C79
                 * 与后16字节异或结果：83914D16 F594C696 FC1DAC05 02142D4B
                 * 再加密结果：        1206C9C5 13ECF080 AD27B29A 5013C5FF
                 * 32个HEXDECIMAL：   31323036 43394335 31334543 46303830 41443237 42323941 35303133 43354646
                 *
                 * 前16字节作为MAC：  31323036 43394335 31334543 46303830
                 * MAC（字符串形式）：1206C9C513ECF080
                 */
        }
}
