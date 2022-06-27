package com.zsl.datastructalgorithm.date20220626;

/**
 * 素组循环队列，存储容量为 capacity - 1；达到上限直接抛弃
 *
 * @author zsl
 * @date 2022/6/26 18:46
 * @email 249269610@qq.com
 */
public class ArrayQueue {

    // 元素数组
    private Integer[] elements;
    // 头
    private int head;
    // 尾
    private int tail;
    // 容量
    private final int capacity;

    public ArrayQueue(int capacity) {
        this.elements = new Integer[capacity];
        this.head = 0;
        this.tail = 0;
        this.capacity = capacity;
    }

    /**
     * 入队
     */
    public boolean enqueue(Integer element) {
        // 判断队列是否有空闲
        if (tail + 1 == head) return false;

        elements[tail++] = element;

        // 边界处理
        if (tail == capacity) tail = 0;
        return true;
    }

    /**
     * 出队
     */
    public Integer dequeue() {
        // 判断是否有元素
        if (tail == head) return null;

        Integer element = elements[head++];

        // 边界处理
        if (head == capacity) head = 0;
        return element;
    }


    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(10);
        for (int i = 0; i < 16; i++) {
            System.out.println(String.format("%02d:enqueue element=%02d, 结果 %s", i, i, arrayQueue.enqueue(i)));
            if (i == 7) {
                System.out.println(String.format("%02d:dequeue ,结果 %s", i, arrayQueue.dequeue()));
            }

            if (i == 14) {
                System.out.println(String.format("%02d:dequeue ,结果 %s", i, arrayQueue.dequeue()));
            }
        }

        for (int i = 0; i < 14; i++) {
            System.out.println(String.format("%02d:dequeue ,结果 %s", i, arrayQueue.dequeue()));
        }
    }
}
