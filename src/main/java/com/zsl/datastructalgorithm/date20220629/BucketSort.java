package com.zsl.datastructalgorithm.date20220629;

import com.zsl.datastructalgorithm.date20220627.InsertSort;

import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

/**
 * 桶排序(线性排序，时间复杂度O(n))
 *          针对数据范围划分多个桶，桶之间有序，对桶内数据再排序，从而有序
 *
 * @author zsl
 * @date 2022/6/29 13:17
 * @email 249269610@qq.com
 */
public class BucketSort {

    public static void main(String[] args) {
        Random random = new Random(41);
        Set<Integer> set = new HashSet<>(2000);
        for (int i = 0; i < 2000; i++) {
            set.add(random.nextInt(10000));
        }
        ;
        Integer[] integers = set.toArray(new Integer[]{});
        int[] ints = new int[integers.length];
        for (int i = 0; i < integers.length; i++) {
            ints[i] = integers[i];
        }
        sort(ints);
        System.out.println();
    }



    /**
     * 对0-10000以内数组进行排序
     */
    public static void sort(int[] elements){
        if (elements.length < 2) return;

        bucketSort(elements);
    }

    private static void bucketSort(int[] elements) {
        // 元素个数少于100个使用插入排序
        if (elements.length < 100) {
            InsertSort.sort(elements);
        }

        // 桶排序
        Bucket[] buckets = new Bucket[10];
        for (int i = 0; i < elements.length; i++) {
            // 获取应该存储的桶位
            int bucketIndex = elements[i] / 2000;

            // 获取桶
            Bucket bucket = buckets[bucketIndex];

            // 如果桶为空就创建
            if (Objects.isNull(bucket)) {
                buckets[bucketIndex] = new Bucket();
                bucket = buckets[bucketIndex];
            }

            bucket.add(elements[i]);
        }

        int index = 0;
        // 遍历桶
        for (int i = 0; i < buckets.length; i++) {
            if (Objects.nonNull(buckets[i])) {
                // 获取桶信息
                int[] ints = buckets[i].getElements();
                int size = buckets[i].getSize();
                // 遍历桶中元素
                for (int j = 0; j < size; j++) {
                    elements[index++] = ints[j];
                }
            }
        }
    }


    /**
     * 桶对象
     */
    public static class Bucket {

        private int[] elements;
        private int size;

        public Bucket() {
            this.elements = new int[16];
            this.size = 0;
        }

        /**
         * 使用插入排序 保证桶中元素有序
         */
        public void add(int element) {
            // 扩容
            if (elements.length == size) {
                int[] dest = new int[size << 2];
                System.arraycopy(elements, 0, dest, 0, size);
                elements = dest;
            }

            int i = 0;
            // 利用插入排序
            for (; i < size; ++i) {
                // 找到要插入的位置
                if (elements[i] > element) {
                    // 先移动
                    for (int j = size; j > i; --j) {
                        elements[j] = elements[j - 1];
                    }
                    break;
                }
            }
            // 再存储
            elements[i] = element;
            ++size;
        }

        public int[] getElements() {
            return elements;
        }

        public int getSize() {
            return size;
        }
    }
}
