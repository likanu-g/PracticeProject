package org.example.algorithm.stack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    private MyStack myStack;

    @BeforeEach
    void setUp() {
        myStack = new MyStack(5);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void push() {
        myStack.push(1);
        assertEquals(1, myStack.data[0]);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        assertEquals(5, myStack.data[4]);
        assertDoesNotThrow(() -> myStack.push(6));
        assertEquals(10, myStack.capacity);
        assertEquals(6, myStack.data[5]);
    }

    @Test
    void pop() {
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        assertEquals(5, myStack.pop());
        assertEquals(5, myStack.capacity);
    }

    @Test
    void peek() {
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        assertEquals(5, myStack.peek());
        myStack.pop();
        assertEquals(4, myStack.peek());
    }

    @Test
    void matchBracket() {
        assertTrue(myStack.matchBracket("([])"));
        assertFalse(myStack.matchBracket("([(])"));
    }
}