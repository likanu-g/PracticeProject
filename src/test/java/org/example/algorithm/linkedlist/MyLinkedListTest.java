package org.example.algorithm.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MyLinkedListTest {

    private MyLinkedList myLinkedList;

    private MyLinkedList myLinkedList1;

    @BeforeEach
    void setup() {
        myLinkedList = new MyLinkedList();
        myLinkedList1 = new MyLinkedList();
    }

    @Test
    void insertNode() {
        myLinkedList.insertNode(1, 1);
        assertEquals(myLinkedList.head.data, 1);
        assertEquals(myLinkedList.length, 1);
        myLinkedList.insertNode(2, 2);
        myLinkedList.print();
        assertEquals(myLinkedList.head.next.data, 2);
        assertEquals(myLinkedList.length, 2);
        assertThrows(UnsupportedOperationException.class, () -> myLinkedList.insertNode(1, -1));
    }

    @Test
    void deleteNode() {
        //初始化5个接单的链表
        myLinkedList.insertNode(1, 1);
        myLinkedList.insertNode(2, 2);
        myLinkedList.insertNode(3, 3);
        myLinkedList.insertNode(4, 4);
        myLinkedList.insertNode(5, 5);
        myLinkedList.print();
        assertEquals(myLinkedList.getNode(1), 1);
        assertEquals(myLinkedList.length, 5);
        myLinkedList.deleteNode(1);
        assertEquals(myLinkedList.getNode(1), 2);
        assertEquals(myLinkedList.length, 4);
        myLinkedList.print();
    }

    @Test
    void mergeLinkedList() {
        //初始化 linkedList
        myLinkedList.insertNode(1, 1);
        myLinkedList.insertNode(3, 2);
        myLinkedList.insertNode(5, 3);
        myLinkedList.insertNode(7, 4);
        myLinkedList.insertNode(9, 5);
        //初始化 linkedList1
        myLinkedList1.insertNode(2, 1);
        myLinkedList1.insertNode(4, 2);
        myLinkedList1.insertNode(6, 3);
        myLinkedList1.insertNode(8, 4);
        myLinkedList1.insertNode(10, 5);

        MyLinkedList myLinkedList2 = MyLinkedList.mergeLinkedList(myLinkedList, myLinkedList1);
        assertEquals(myLinkedList2.head.data, 1);
        assertEquals(myLinkedList2.getNode(2), 2);
        assertEquals(myLinkedList2.getNode(3), 3);
        assertEquals(myLinkedList2.getNode(4), 4);
        //assertEquals(myLinkedList2.length, myLinkedList1.length + myLinkedList.length);
    }

    @Test
    void mergeLinkedList1() {
        //初始化 linkedList
        myLinkedList.insertNode(1, 1);
        myLinkedList.insertNode(3, 2);
        myLinkedList.insertNode(5, 3);
        myLinkedList.insertNode(7, 4);
        myLinkedList.insertNode(9, 5);
        //初始化 linkedList1
        myLinkedList1.insertNode(2, 1);
        myLinkedList1.insertNode(4, 2);
        myLinkedList1.insertNode(6, 3);
        myLinkedList1.insertNode(8, 4);
        //myLinkedList1.insertNode(10, 5);

        MyLinkedList myLinkedList2 = MyLinkedList.mergeLinkedList(myLinkedList, myLinkedList1);
        assertEquals(myLinkedList2.head.data, 1);
        assertEquals(myLinkedList2.getNode(2), 2);
        assertEquals(myLinkedList2.getNode(3), 3);
        assertEquals(myLinkedList2.getNode(9), 9);
        //assertEquals(myLinkedList2.length, myLinkedList1.length + myLinkedList.length);
    }
}