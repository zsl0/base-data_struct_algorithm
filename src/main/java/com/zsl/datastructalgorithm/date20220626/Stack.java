package com.zsl.datastructalgorithm.date20220626;

/**
 * @Author zsl
 * @Date 2022/6/26 10:33
 * @Email 249269610@qq.com
 */
public class Stack {

    // 数组元素
    private Integer[] elements;
    // 容量
    private final int capacity;
    // 当前栈存储元素个数
    private int size;

    public Stack(int capacity) {
        this.elements = new Integer[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    /**
     * 入栈
     */
    public boolean push(Integer element) {
        // 边界处理
        if (size == capacity) {
            return false;
        }

        elements[size++] = element;
        return true;
    }

    /**
     * 出栈
     */
    public Integer pop() {
        // 边界处理
        if (size == 0) {
            return null;
        }

        return elements[--size];
    }

    /**
     * 查看栈顶元素
     */
    public Integer peek() {
        // 边界处理
        if (size == 0) {
            return null;
        }

        return elements[size - 1];
    }



    public static void main(String[] args) {
        Stack stack = new Stack(10);
        for (int i = 0; i < 16; i++) {
            System.out.println(String.format("%02d:push number: %d, 结果:%s", i, i,  stack.push(i)));
        }

        for (int i = 0; i < 16; i++) {
            Integer pop = stack.pop();
            System.out.println(String.format("%02d:pop 结果:%d", i, pop));
        }
    }

}
