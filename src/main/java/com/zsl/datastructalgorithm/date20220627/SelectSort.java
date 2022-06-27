package com.zsl.datastructalgorithm.date20220627;

import java.util.Arrays;

/**
 * 选择排序
 *      每次选择最大或最小元素进行交换，只交换一次，但不是稳定的排序
 * @author zsl
 * @date 2022/6/27 22:02
 * @email 249269610@qq.com
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] ints = {44, 54, 523, 5, 6, 1, 543, 66, 7};
        sort(ints);
        System.out.println(Arrays.toString(ints));
    }

    public static void sort(int[] elements) {
        if (elements.length < 2) {
            return ;
        }

        for (int i = 0; i < elements.length; i++) {
            int minIndex = i;
            for (int j = i; j < elements.length; j++) {
                if (elements[j] < elements[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = elements[minIndex];
            elements[minIndex] = elements[i];
            elements[i] = tmp;
        }
    }
}
