package com.zsl.datastructalgorithm.date20220629;

import java.util.Random;

/**
 * 计数排序(线性排序，时间复杂度O(n))
 *      限制条件高，针对特定数据；如对年龄排序，假设[0, 120]都是会出现的结果，先遍历一边元素，计算每种结果的个数存储到数组中（new int[121]），
 *      再计数求和，遍历元素存储到对应的位置。
 *
 * @author zsl
 * @date 2022/6/29 13:18
 * @email 249269610@qq.com
 */
public class CountingSort {

    public static void main(String[] args) {
        Random random = new Random(41);
        int[] ints = new int[1000];
        for (int i = 0; i < 1000; i++) {
            ints[i] = random.nextInt(121);
        }

        sort(ints, 121);
        System.out.println();
    }

    public static void sort(int[] elements, int count) {
        if (elements.length < 2) return;

        countingSort(elements, count);
    }

    private static void countingSort(int[] elements, int count) {
        // 获取每个元素出现次数
        int[] counts = new int[count];
        for (int i = 0; i < elements.length; i++) {
            ++counts[elements[i]];
        }

        // 累加每个元素加上之前元素出现的次数
        for (int i = 1; i < counts.length; i++) {
            counts[i] = counts[i] + counts[i -1];
        }

        // 从后往前遍历
        int[] tmp = new int[elements.length];
        for (int i = elements.length; i > 0; --i) {
            int element = elements[i - 1];
            int index = --counts[element];
            tmp[index] = element;
        }

        // 拷贝排序好的元素
        System.arraycopy(tmp, 0, elements, 0, elements.length);
    }
}
