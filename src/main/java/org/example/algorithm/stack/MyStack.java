package org.example.algorithm.stack;

import java.util.Arrays;

public class MyStack {
    int[] data; //数组实现栈
    int top; //栈顶指针
    int capacity;//栈容量

    public MyStack(int capacity) {
        if (capacity < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.data = new int[capacity];
        this.top = 0;
        this.capacity = capacity;
    }

    /**
     * 进栈
     *
     * @param val
     */
    public void push(int val) {
        //如果top指针指向栈顶
        if (top >= capacity) {
            //扩容data为原来容量的两倍
            capacity = capacity << 1;
            data = Arrays.copyOf(data, capacity);
        }
        data[top++] = val;
    }

    /**
     * 出栈
     *
     * @return
     */
    public int pop() {
        int tmp = data[--top];
        data[top] = 0;
        return tmp;
    }

    /**
     * 显示栈顶元素
     *
     * @return
     */
    public int peek() {
        return data[top - 1];
    }


}
