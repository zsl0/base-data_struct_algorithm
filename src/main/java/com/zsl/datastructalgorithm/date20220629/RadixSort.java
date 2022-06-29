package com.zsl.datastructalgorithm.date20220629;

import com.zsl.datastructalgorithm.date20220627.InsertSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 基数排序(线性排序，时间复杂度O(n))
 *      限制条件高，针对特定数据；如对11位手机号排序，通过对每位[0,9]的数字进行排序，从第1位到第11位逐渐有序，要求是稳定的。
 *
 * @author zsl
 * @date 2022/6/29 13:20
 * @email 249269610@qq.com
 */
public class RadixSort {
    static Random random = new Random(41);


    public static void main(String[] args) {
        int elementSize = 1000;

        int[] ints = new int[elementSize];
        for (int i = 0; i < elementSize; i++) {
            ints[i] = generateNumber(6);
        }

        sort(ints, 6);
        System.out.println();
    }

    /**
     * 随机生成1-6位数字
     *
     * @param maxLen 长度
     */
    public static int generateNumber(int maxLen) {
        if (maxLen > 6 || maxLen < 1) maxLen = 6;

        int num = random.nextInt(10);
        for (int i = 1; i < maxLen; i++) {
            num = num * 10 + random.nextInt(10);
        }
        return num;
    }


    public static void sort(int[] elements, int maxLen) {
        if (elements.length < 2) return;

        radixSort(elements, maxLen);
    }

    private static void radixSort(int[] elements, int maxLen) {
        if (elements.length < 100) {
            InsertSort.sort(elements);
            return;
        }

        // 构建基数桶(此处偷懒使用Java链表数据结构，充当桶结构)
        List[] base = new ArrayList[10];
        for (int i = 0; i < base.length; i++) {
            base[i] = new ArrayList<Integer>();
        }


        int remainder = 1;
        for (int i = 0; i < maxLen; i++) {
            remainder *= 10;
            radix_sort_c(elements, base, remainder);
        }
    }

    private static void radix_sort_c(int[] elements, List[] base, int remainder) {
        // 对remainder位进行排序，并存放到对应桶中
        for (int i = 0; i < elements.length; i++) {
            int index = elements[i] % remainder;

            // 缺位直接为0
            if (index < remainder / 10) index = 0;

            while (index >= 10) {
                index /= 10;
            }
            base[index].add(elements[i]);
        }

        // 拷贝到原位置
        int i = 0;
        for (List<Integer> list : base) {
            for (Integer integer : list) {
                elements[i++] = integer;
            }
            list.clear();
        }
    }
}
