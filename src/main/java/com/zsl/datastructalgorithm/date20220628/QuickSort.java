package com.zsl.datastructalgorithm.date20220628;

import java.util.Arrays;

/**
 * 快速排序
 *      采用分治思想，逐渐有序
 *
 * @author zsl
 * @date 2022/6/28 21:02
 * @email 249269610@qq.com
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] elements = new int[]{132, 45, 345, 65, 77, 876, 23, 645, 66, 58};

        sort(elements);
        int[] ints1 = {5, 6};
        int[] ints2 = {6, 5};
        sort(ints1);
        sort(ints2);
        System.out.println(Arrays.toString(elements));
    }

    public static void sort(int[] elements) {
        if (elements.length < 2) {
            return;
        }

        quickSort(elements, 0, elements.length - 1);
    }

    /**
     * 递归执行
     * @param elements 元素数组
     * @param start 起始索引
     * @param end 结束索引
     */
    public static void quickSort(int[] elements, int start, int end) {
        if (end - start <= 0) return;

        // 排序
        int left = start;
        int right = start;

        // 将最后一位当中心值
        int pivot = elements[end];
        int cnt = end - start;
        for (int i = 0; i < cnt; i++) {
            if (elements[right] <= pivot) {
                swap(elements, left, right);
                ++left;
                ++right;
            } else {
                ++right;
            }
        }

        // 将轴移动到中心
        int tmp = elements[left];
        elements[left] = elements[right];
        elements[right] = tmp;

        // 左侧集合
        quickSort(elements, start, left - 1);
        // 右侧集合
        quickSort(elements, left + 1, end);
    }

    /**
     * 交换指定索引元素
     * @param elements 待交换数组
     * @param left
     * @param right
     */
    private static void swap(int[] elements, int left, int right) {
        if (left == right) return;

        int tmp = elements[left];
        elements[left] = elements[right];
        elements[right] = tmp;
    }
}
