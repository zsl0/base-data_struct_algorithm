package com.zsl.datastructalgorithm.date20220628;

import java.util.Arrays;

/**
 * 归并排序
 * 采用分治思想，逐渐有序
 *
 * @author zsl
 * @date 2022/6/28 21:43
 * @email 249269610@qq.com
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] elements = new int[]{132, 45, 345, 65, 77, 876, 23, 645, 66, 58};


        int[] ints1 = {5, 6};
        int[] ints2 = {6, 5};
        sort(elements);
        System.out.println(Arrays.toString(elements));
    }

    public static void sort(int[] elements) {
        if (elements.length < 2) return ;

        mergeSort(elements, 0, elements.length - 1);
    }

    /**
     * 归并逻辑
     *
     * @param elements 元素数组
     * @param start    起始索引
     * @param end      结束索引
     */
    private static void mergeSort(int[] elements, int start, int end) {
        if (end - start == 0) return ;

        int size = end - start;
        int half = size / 2;

        // 分治
        mergeSort(elements, start, half);
        mergeSort(elements, half + 1, end);

        int[] tmp = new int[size + 1];
        int leftIndex = start;
        int rightIndex = half + 1;
        int leftLen = half - start + 1;
        int rightLen = end - half;
        // 比较并插入排序
        for (int i = 0; i < size + 1; i++) {
            if (1 == leftIndex - half) {
                tmp[i] = elements[rightIndex++];
                continue;
            }

            if (1 == rightIndex - end) {
                tmp[i] = elements[leftIndex++];
                continue;
            }


            if (elements[leftIndex] < elements[rightIndex]) {
                tmp[i] = elements[leftIndex++];
            } else {
                tmp[i] = elements[rightIndex++];
            }
        }

        // 写回原数组
        System.arraycopy(tmp, 0, elements, start, rightLen + leftLen);
    }
}