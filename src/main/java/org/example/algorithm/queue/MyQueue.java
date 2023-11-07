package org.example.algorithm.queue;

public class MyQueue {
    private QueueNode front;
    private QueueNode rear;


    public MyQueue() {
        this.front = null;
        this.rear = null;
    }

    /**
     * 入队
     *
     * @param data
     */
    public void enqueue(int data) {
        //创建入队的节点
        QueueNode node = new QueueNode(data);
        if (rear == null) {
            front = node;
            rear = node;
        } else {
            //这里好理解就是在队尾插入新的元素
            rear.next = node;
            //这里给rear赋值是为了标记队尾
            rear = node;
        }
    }

    /**
     * 出队
     *
     * @return
     */
    public Integer dequeue() {
        //队列为空
        if (front == null) {
            return null;
        } else {
            //取出队首元素
            int data = front.data;
            //队首指向它的下一个元素
            front = front.next;
            //
            if (front == null) {
                rear = null;
            }
            return data;
        }
    }

    public Integer peek() {
        if (front != null) {
            return front.data;
        } else {
            return null;
        }
    }
}
