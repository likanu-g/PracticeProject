package org.example.algorithm.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MyLinkedListTest {

    private MyLinkedList myLinkedList;

    @BeforeEach
    void setup() {
        myLinkedList = new MyLinkedList();
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
}