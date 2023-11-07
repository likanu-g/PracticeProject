package org.example.algorithm.queue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MyQueueTest {

    private MyQueue myQueue;

    @BeforeEach
    void setUp() {
        myQueue = new MyQueue();
    }

    @AfterEach
    void tearDown() {
        myQueue = null;
    }

    @Test
    void enqueue() {
        myQueue.enqueue(1);
        assertEquals(1, myQueue.peek());
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        myQueue.enqueue(5);
        assertEquals(1, myQueue.peek());
    }

    @Test
    void dequeue() {
        myQueue.enqueue(1);
        assertEquals(1, myQueue.peek());
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        assertEquals(1, myQueue.peek());
        myQueue.dequeue();
        assertEquals(2, myQueue.peek());
    }

    @Test
    void peek() {
        assertNull(myQueue.peek());
    }
}