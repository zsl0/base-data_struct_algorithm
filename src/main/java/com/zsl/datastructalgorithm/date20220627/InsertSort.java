package com.zsl.datastructalgorithm.date20220627;

import java.util.Arrays;

/**
 * 插入排序
 *      每次插入，选择合适的位置，即插入过程中排序，后面的元素向后移动
 * @author zsl
 * @date 2022/6/27 21:43
 * @email 249269610@qq.com
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] ints = {44, 54, 523, 5, 6, 1, 543, 66, 7};

        sort(ints);
        System.out.println(Arrays.toString(ints));
    }

    public static void sort(int[] elements) {
        if (elements.length < 2) {
            return ;
        }

        for (int i = 1; i < elements.length; i++) {
            for (int j = 0; j < i; j++) {
                // 找到位置，将index i,作为存储位置，进行移动
                if (elements[i] < elements[j]) {
                    int tmp = elements[i];
                    elements[i] = elements[j];
                    elements[j] = tmp;
                }
            }
        }
    }
}
