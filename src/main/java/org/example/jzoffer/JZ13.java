package org.example.jzoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class JZ13 {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        reOrderArray2(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void reOrderArray2(int[] array) {
        List list = new ArrayList();
        List list1 = new ArrayList();
        if (array == null || array.length == 0 || array.length == 1) return;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                list1.add(array[i]);
            } else {
                list.add(array[i]);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            array[i] = Integer.valueOf(list.get(i).toString());
        }
        for (int i = 0; i < list1.size(); i++) {
            array[list.size() + i ] = Integer.valueOf(list1.get(i).toString());
        }
    }

    public static void reOrderArray(int[] array) {
        // 拿到首次偶数坐标和首次偶数后面的出现的基数
        if (array == null || array.length == 0 || array.length == 1) return;
        int i = -1;
        int j = -1;

        for (int k = 0; k <= array.length - 1; k++) {
            if (array[k] % 2 == 0) {
                j = k;
                break;
            }
        }
        for (int k = j; k <= array.length - 1; k++) {
            if (array[k] % 2 != 0) {
                i = k;
                break;
            }
        }
        System.out.println(i + "==" + j);
        if (i == -1 || j == -1) return;
        if (i < j) return;
        //偶数后移
        int temp = array[i];
        for (int k = i; k > j; k--) {
            array[k] = array[k - 1];
        }
        array[j] = temp;
        reOrderArray(array);

    }
}
