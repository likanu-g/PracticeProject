package org.example.algorithm.linkedlist;

import java.util.StringJoiner;

public class MyLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }


    Node head = null; //链表头,链表的第一个节点
    int length; //链表的长度


    /**
     * 插入节点(新增一个节点)
     *
     * @param data
     * @param index
     * @return
     */
    boolean insertNode(int data, int index) {
        if (index < 1 || index > length + 1) {
            throw new UnsupportedOperationException();
        }
        //在索引是1的位置添加一个
        if (index == 1) {
            //如果链表头为空
            if (head == null) {
                head = new Node(data);
            } else {
                //创建一个node作为链表的节点
                Node newNode = new Node(data);
                //链表原来的head是第一个节点，且节点不为空，现在新增一个节点在index = 1的位置，所以取代了第一个个节点为head
                newNode.next = head; //原来的head就是现在newNode的下一个节点
                head = newNode; //新增的节点就是现在的新head
            }
        } else {
            //如果索引不是1, 先创建一个head节点的指针
            Node pointer = head;
            int i = 1;
            // 遍历整个链表，找到要插入的那个节点的前一个节点
            while (i < index - 1 && pointer != null) {
                pointer = pointer.next;
                i++;
            }
            //创建一个要插入的节点
            Node newNode = new Node(data);
            //创建一个通过遍历得到的pointer的next指针的指针pNext
            assert pointer != null;
            Node pNext = pointer.next;
            //将原来的pointer的next节点指向新添加的节点
            pointer.next = newNode;
            //将新添加的节点的next指针指向原来pointer的next也就是前面创建的pNext
            newNode.next = pNext;
        }
        length++;
        return true;

    }


    /**
     * 删除一个节点
     *
     * @param index
     * @return
     */
    public boolean deleteNode(int index) {
        if (index < 1 || length < 1 || index > length) {
            throw new UnsupportedOperationException();
        }

        //删除第一个节点
        if (index == 1) {
            //直接将head.next指向head即可
            head = head.next;
        } else {
            //注意这里是从1开始的，比从0开始少循环次
            int i = 1;
            Node tmp = head;
            //遍历查找要删除的索引的节点的上一个节点
            while (i < index) {
                //找到是tmp的上一个
                tmp = tmp.next;
                i++;
            }
            //原先要删除的index对应的节点的上一个节点是tmp,
            //这里要删除tmp.next,于是先找到tmp.next.next，
            // 因为如果不先找到它，直接把tmp.next设置为null后，index后面所有的节点就都是null
            Node tmpNext = tmp.next.next;
            //删除tmp.next
            //tmp.next = null;
            //将tmp.next指向上面找到的tmp.next.next
            tmp.next = tmpNext;
            //这里可以简写成
            //tmp.next = tmp.next.next

        }
        length--;
        return true;
    }

    public int getNode(int index) {
        if (index > length && index < 1) {
            return -1;
        }
        Node node = head;
        for (int i = 1; i < index; i++) {
            node = node.next;
        }
        return node.data;
    }


    public void print() {
        StringBuilder stringBuilder = new StringBuilder();
        StringJoiner stringJoiner = new StringJoiner("->");
        if (head == null) {
            System.out.println(stringBuilder.append("[]"));
        } else {
            Node node = head;
            while (node != null) {
                stringJoiner.add(node.data + "");
                node = node.next;
            }
            System.out.println(stringBuilder.append("[").append(stringJoiner).append("]"));
        }
    }
}
