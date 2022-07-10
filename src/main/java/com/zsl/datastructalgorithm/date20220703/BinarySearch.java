package com.zsl.datastructalgorithm.date20220703;

import com.zsl.datastructalgorithm.date20220627.InsertSort;

import java.util.Arrays;

/**
 * 二分查找
 *
 * @author zsl
 * @date 2022/7/3 8:28
 * @email 249269610@qq.com
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] ints = new int[]{1, 5, 7, 54, 867, 765, 567, 34, 52, 23, 28, 97, 73};

        InsertSort.sort(ints);

        System.out.println(Arrays.toString(ints));
        System.out.println(search(ints, 34));
        System.out.println();
    }

    public static int search(int[] elements, int element) {
        if (elements.length <= 0) return -1;

        int left = 0;
        int right = elements.length - 1;
        int mid = (right - left) / 2 + left;;

        // 二分查找元素
        while (right > left) {
            if (elements[mid] == element) {
                break;
            } else if (elements[mid] < element) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = (right - left) / 2 + left;
        }

        int index = -1;
        if (elements[mid] == element) {
            index = mid;
        }

        return index;
    }

}
