package org.example.algorithm.array;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQuestionTest {

    private int[] nums;

    private ArrayQuestion arrayQuestion;

    @BeforeEach
    void setUp() {
        nums = new int[]{7, 2, 3, 5, 8, 10, 6};
        arrayQuestion = new ArrayQuestion();
    }

    @AfterEach
    void tearDown() {
        nums = null;
    }

    @Test
    void reArrange() {
        arrayQuestion.reArrange(nums);
        assertArrayEquals(new int[]{7, 5, 3, 2, 8, 10, 6}, nums);
        //System.out.println(Arrays.toString(nums));
    }

    @Test
    void isEven() {
        assertTrue(arrayQuestion.isEven(2));
        assertTrue(arrayQuestion.isEven(4));
        assertTrue(arrayQuestion.isEven(6));
        assertTrue(arrayQuestion.isEven(8));
        assertTrue(arrayQuestion.isEven(0));
    }

    @Test
    void reArrangeInOrder1() {
        arrayQuestion.reArrangeInOrder1(nums);
        assertArrayEquals(new int[]{7, 3, 5, 2, 8, 10, 6}, nums);
    }

    @Test
    void reArrangeInOrder2() {
        arrayQuestion.reArrangeInOrder2(nums);
        assertArrayEquals(new int[]{7, 3, 5, 2, 8, 10, 6}, nums);
    }

    @Test
    void sumOfTwoNum() {
        nums = new int[]{1, 2, 4, 5, 8, 13, 17, 21, 36};
        final List<int[]> ints = arrayQuestion.sumOfTwoNum(nums, 21);
        //assertIterableEquals(List.of(new int[]{1, 5}), ints);
        assertEquals(3, ints.size());
        assertEquals(2, ints.get(0)[0]);
        assertEquals(6, ints.get(0)[1]);
        assertEquals(4, ints.get(1)[0]);
        assertEquals(5, ints.get(1)[1]);
        assertEquals(5, ints.get(2)[0]);
        assertEquals(4, ints.get(2)[1]);
    }

    @Test
    void intersectionOfTwoOrderArray() {
        nums = new int[]{1, 2, 4, 5, 8, 13, 17, 21, 36};
        int[] nums1 = new int[]{1, 5, 8, 13, 19, 20};
        List<Integer> list = arrayQuestion.intersectionOfTwoOrderArray(nums, nums1);
        assertIterableEquals(List.of(1, 5, 8, 13), list);
    }
}