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
        assertEquals(myLinkedList.head.next.data, 2);
        assertEquals(myLinkedList.length, 2);
        assertThrows(UnsupportedOperationException.class, () -> myLinkedList.insertNode(1, -1));
    }

    @Test
    void deleteNode() {
    }
}