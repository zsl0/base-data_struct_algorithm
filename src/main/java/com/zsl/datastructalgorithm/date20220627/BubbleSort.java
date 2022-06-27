package com.zsl.datastructalgorithm.date20220627;

import java.util.Arrays;

/**
 * 冒泡排序
 *      每边都需要交换比较结果的元素
 * @author zsl
 * @date 2022/6/27 21:28
 * @email 249269610@qq.com
 */
public class BubbleSort {

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
            boolean swap = false;
            for (int j = 0; j < elements.length - i; j++) {
                if (elements[j + 1] < elements[j]) {
                    int tmp = elements[j + 1];
                    elements[j + 1] = elements[j];
                    elements[j] = tmp;
                    swap = true;
                }
            }
            if (!swap) break;
        }
    }
}
