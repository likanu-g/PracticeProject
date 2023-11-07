package org.example.algorithm.queue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StackQueueTest {

    private StackQueue stackQueue;

    @BeforeEach
    void setUp() {
        stackQueue = new StackQueue();
    }

    @AfterEach
    void tearDown() {
        stackQueue = null;
    }

    @Test
    void enqueue() {
        stackQueue.enqueue(1);
        stackQueue.enqueue(2);
        stackQueue.enqueue(3);
        stackQueue.enqueue(4);
        stackQueue.enqueue(5);
        assertEquals(1, stackQueue.dequeue());

    }
}