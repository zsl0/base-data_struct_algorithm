package com.zsl.datastructalgorithm.date20220711;

import lombok.Data;

/**
 * 实现二叉树前中后序遍历
 *  结论：
 *    - 最大堆、最小堆 前序遍历有序
 *    - AVL树 中序遍历有序
 *
 * @author zsl
 * @date 2022/7/11
 * @email 249269610@qq.com
 */
@Data
public class BinaryTree {


    public static void main(String[] args) {
//        int[] ints = new int[(int) Math.pow(2, 8)];
//        for (int i = 0; i < ints.length; i++) {
//            ints[i] = (int) Math.round(Math.random() * 1000);
//        }
//        ints[0] = 0; // 哨兵
//
//        System.out.println(Arrays.toString(ints));

        // 最小堆结果
        System.out.println();
        System.out.println("================================ 最小堆 ================================");
        int[] little = new int[]{0, 1, 2, 3, 4, 5, 6};
        System.out.println("----------------------------- prev -----------------------------");
        prevFor(little);
        System.out.println("----------------------------- mid -----------------------------");
        midFor(little);
        System.out.println("----------------------------- suffix -----------------------------");
        suffixFor(little);

        System.out.println();
        System.out.println("================================ 最大堆 ================================");
        // 最大堆结果
        int[] big = new int[]{0, 6, 5, 4, 3, 2, 1};
        System.out.println("----------------------------- prev -----------------------------");
        prevFor(big);
        System.out.println("----------------------------- mid -----------------------------");
        midFor(big);
        System.out.println("----------------------------- suffix -----------------------------");
        suffixFor(big);


        System.out.println();
        System.out.println("================================ AVL ================================");
        // 平衡树，左小右大
        int[] avl = new int[]{0, 4, 2, 6, 1, 3, 5};
        System.out.println("----------------------------- prev -----------------------------");
        prevFor(avl);
        System.out.println("----------------------------- mid -----------------------------");
        midFor(avl);
        System.out.println("----------------------------- suffix -----------------------------");
        suffixFor(avl);
    }


    /**
     * 前序遍历
     */
    public static void prevFor(int[] elements) {
        if (elements.length == 1) {
            System.out.println(elements[0]);
        }

        nextNodePrevFor(elements, 1);
        System.out.println();
    }

    /**
     * 中序遍历
     */
    public static void midFor(int[] elements) {
        if (elements.length == 1) {
            System.out.println(elements[0]);
        }

        nextNodeMidFor(elements, 1);
        System.out.println();
    }

    /**
     * 后序遍历
     */
    public static void suffixFor(int[] elements) {
        if (elements.length == 1) {
            System.out.println(elements[0]);
        }

        nextNodeSuffixFor(elements, 1);
        System.out.println();
    }

    /**
     * 前中后序遍历，只是打印位置不同
     */
    public static void nextNodeMidFor(int[] elements, int index) {
        if (index >= elements.length) {
            return ;
        }

        nextNodeMidFor(elements, index * 2);
        System.out.print(elements[index]);
        System.out.print(",");
        nextNodeMidFor(elements, index * 2 + 1);
    }

    /**
     * 前中后序遍历，只是打印位置不同
     */
    public static void nextNodePrevFor(int[] elements, int index) {
        if (index >= elements.length) {
            return ;
        }

        System.out.print(elements[index]);
        System.out.print(",");
        nextNodePrevFor(elements, index * 2);
        nextNodePrevFor(elements, index * 2 + 1);
    }

    /**
     * 前中后序遍历，只是打印位置不同
     */
    public static void nextNodeSuffixFor(int[] elements, int index) {
        if (index >= elements.length) {
            return ;
        }

        nextNodeSuffixFor(elements, index * 2);
        nextNodeSuffixFor(elements, index * 2 + 1);
        System.out.print(elements[index]);
        System.out.print(",");
    }





    @Data
    public static class Node<T> {
        private T data;
        private Node<T> prevNode;   // 前驱节点(父节点)
        private Node<T> leftNode;   // 左子节点
        private Node<T> rightNode;  // 右子节点
    }
}
