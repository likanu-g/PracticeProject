package org.example.algorithm.stack;

import java.util.Arrays;
import java.util.Stack;

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
        if (isEmpty()) {
            return -1;
        } else {
            int tmp = data[--top];
            data[top] = 0;
            return tmp;
        }
    }

    /**
     * 显示栈顶元素
     *
     * @return
     */
    public int peek() {
        return data[top - 1];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    /**
     * 匹配括号
     *
     * @param expressing
     * @return
     */
    public boolean matchBracket(String expressing) {
        Stack<Character> stack = new Stack<>();
        for (char c : expressing.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false; // 括号不匹配
                }
                char top = stack.pop();
                // 检查括号是否匹配
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false; // 括号不匹配
                }
            }
        }
        return stack.isEmpty(); // 如果栈为空，括号匹配
    }
}
