package org.example.algorithm.arrayandstring;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayAndStringQuestionTest {

    private int[] nums;

    private ArrayAndStringQuestion arrayAndStringQuestion;

    @BeforeEach
    void setUp() {
        nums = new int[]{7, 2, 3, 5, 8, 10, 6};
        arrayAndStringQuestion = new ArrayAndStringQuestion();
    }

    @AfterEach
    void tearDown() {
        nums = null;
    }

    @Test
    void reArrange() {
        arrayAndStringQuestion.reArrange(nums);
        assertArrayEquals(new int[]{7, 5, 3, 2, 8, 10, 6}, nums);
        //System.out.println(Arrays.toString(nums));
    }

    @Test
    void isEven() {
        assertTrue(arrayAndStringQuestion.isEven(2));
        assertTrue(arrayAndStringQuestion.isEven(4));
        assertTrue(arrayAndStringQuestion.isEven(6));
        assertTrue(arrayAndStringQuestion.isEven(8));
        assertTrue(arrayAndStringQuestion.isEven(0));
    }

    @Test
    void reArrangeInOrder1() {
        arrayAndStringQuestion.reArrangeInOrder1(nums);
        assertArrayEquals(new int[]{7, 3, 5, 2, 8, 10, 6}, nums);
    }

    @Test
    void reArrangeInOrder2() {
        arrayAndStringQuestion.reArrangeInOrder2(nums);
        assertArrayEquals(new int[]{7, 3, 5, 2, 8, 10, 6}, nums);
    }

    @Test
    void sumOfTwoNum() {
        nums = new int[]{1, 2, 4, 5, 8, 13, 17, 21, 36};
        final List<int[]> ints = arrayAndStringQuestion.sumOfTwoNum(nums, 21);
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
        List<Integer> list = arrayAndStringQuestion.intersectionOfTwoOrderArray(nums, nums1);
        assertIterableEquals(List.of(1, 5, 8, 13), list);
    }

    @Test
    void getLongestCommonPrefix() {
        String[] strings = new String[]{"abcde", "abcab", "abefc"};
        String result = arrayAndStringQuestion.getLongestCommonPrefix(strings);
        assertEquals("ab", result);
    }

    @Test
    void getCommonPrefix() {
        String string1 = "abcde";
        String string2 = "abefc";
        String result = arrayAndStringQuestion.getCommonPrefix(string1, string2);
        assertEquals("ab", result);
    }

    @Test
    void getLongestCommonSubString() {
        assertEquals("cd", arrayAndStringQuestion.getLongestCommonSubString("abcdefg", "cdaf"));
    }

    @Test
    void getMinConsecutiveArray() {
        assertIterableEquals(List.of(4, 5), arrayAndStringQuestion.getMinConsecutiveArray(new int[]{2, 3, 1, 2, 4, 3}, 7));
    }
}