package com.zsl.datastructalgorithm.date20220703.date20220706;

import lombok.Data;

/**
 * 实现二叉树前中后序遍历
 *
 * @author zsl
 * @date 2022/7/6 21:52
 * @email 249269610@qq.com
 */
@Data
public class BinaryTree {



    public void prevFor() {

    }

    public void midFor() {

    }

    public void suffixFor() {

    }

    @Data
    public static class Node<T> {
        private T data;
        private Node<T> prevNode;   // 前驱节点(父节点)
        private Node<T> leftNode;   // 左子节点
        private Node<T> rightNode;  // 右子节点
    }
}
