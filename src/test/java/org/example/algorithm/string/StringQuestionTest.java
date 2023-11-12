package org.example.algorithm.string;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringQuestionTest {

    private int[] nums;

    private StringQuestion stringQuestion;

    @BeforeEach
    void setUp() {
        nums = new int[]{7, 2, 3, 5, 8, 10, 6};
        stringQuestion = new StringQuestion();
    }

    @AfterEach
    void tearDown() {
        nums = null;
    }

    @Test
    void reArrange() {
        stringQuestion.reArrange(nums);
        assertArrayEquals(new int[]{7, 5, 3, 2, 8, 10, 6}, nums);
        //System.out.println(Arrays.toString(nums));
    }

    @Test
    void isEven() {
        assertTrue(stringQuestion.isEven(2));
        assertTrue(stringQuestion.isEven(4));
        assertTrue(stringQuestion.isEven(6));
        assertTrue(stringQuestion.isEven(8));
        assertTrue(stringQuestion.isEven(0));
    }

    @Test
    void reArrangeInOrder1() {
        stringQuestion.reArrangeInOrder1(nums);
        assertArrayEquals(new int[]{7, 3, 5, 2, 8, 10, 6}, nums);
    }

    @Test
    void reArrangeInOrder2() {
        stringQuestion.reArrangeInOrder2(nums);
        assertArrayEquals(new int[]{7, 3, 5, 2, 8, 10, 6}, nums);
    }
}