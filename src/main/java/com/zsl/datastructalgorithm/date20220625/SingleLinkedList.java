package com.zsl.datastructalgorithm.date20220625;

import lombok.Data;

/**
 * 实现单链表反转
 *
 * @Author zsl
 * @Date 2022/6/25 22:22
 * @Email 249269610@qq.com
 */
public class SingleLinkedList<T> {

    // 头
    private Node<T> head;
    // 尾
    private Node<T> tail;
    // 大小
    private int size = 0;

    /**
     * 新增元素
     */
    public void add(T obj) {
        Node<T> node = new Node<>();
        node.obj = obj;

        if (head == null) {
            head = node;
            tail = node;
            size = 1;
        } else {
            tail.next = node;
            tail = node;
            ++size;
        }
    }

    /**
     * 获取索引元素
     */
    public T get(int index) {
        if (size == 0) {
            return null;
        }

        T obj = null;
        if (index < size) {
            Node<T> currNode = head;
            for (int i = 0; i < index; i++) {
                currNode = currNode.next;
            }
            obj = currNode.obj;
        }
        return obj;
    }

    /**
     * 移除索引元素
     */
    public boolean remove(int index) {
        // 边界处理(空链表、索引无效)
        if (size == 0 || index >= size || index < 0) {
            return false;
        }

        // 特殊处理
        if (index == 0) {
            if (size == 1) {
                head = null;
                tail = null;
                return true;
            } else {
                head = head.next;
            }
        }

        // 查找索引元素
        Node<T> prevNode = null;
        Node<T> currNode = head;
        for (int i = 0; i < index; i++) {
            prevNode = currNode;
            currNode = currNode.next;
        }

        // 移除节点
        assert prevNode != null;
        prevNode.next = currNode.next;

        // 末尾处理
        if (index == --size) {
            tail = prevNode;
        }
        return true;
    }

    /**
     * 反转
     * 遍历一遍，缺点：反转过程中get(index)会出错
     */
    public void reverse() {
        if (size < 2) {
            return;
        }

        tail = head;

        Node<T> currNode = head;
        Node<T> nextNode = currNode.next;
        head.next = null;

        for (int i = 0; i < size - 1; i++) {
            currNode = nextNode;
            nextNode = nextNode.next;
            currNode.next = head;
            head = currNode;
        }
    }

    @Override
    public String toString() {
        return "SingleList{" +
                "head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }

    /**
     * 节点
     */
    @Data
    public static class Node<T> {
        private T obj;
        private Node<T> next;
    }



    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);
        list.remove(4);
        System.out.println(list);
        list.reverse();
        System.out.println(list);
    }
}
