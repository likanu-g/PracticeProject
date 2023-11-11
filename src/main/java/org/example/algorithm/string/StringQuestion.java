package org.example.algorithm.string;

import java.util.Arrays;

public class StringQuestion {

    /**
     * 重排数组元素，使其左边是奇数，右边是偶数
     *
     * @param array 数组
     */
    public void reArrange(int[] array) {
        //使用双指针
        int low = 0;
        int high = array.length - 1;
        while (true) {
            //如果是奇数
            while (low < high && !isEven(array[low])) {
                low++;
            }
            while (low < high && isEven(array[high])) {
                high--;
            }
            if (low >= high) {
                return;
            } else {
                swap(array, low, high);
                low++;
                high--;
            }
        }
    }

    /**
     * 判断数字是不是偶数
     *
     * @param num 数组
     * @return 如果是偶数返回 true ,否则返回 false
     */
    public boolean isEven(int num) {
        return num % 2 == 0;
    }

    /**
     * 交换数组元素的位置
     *
     * @param nums 数组
     * @param low  索引low
     * @param high 索引high
     */
    public void swap(int[] nums, int low, int high) {
        int tmp = nums[low];
        nums[low] = nums[high];
        nums[high] = tmp;
    }

    /**
     * 按照顺序左右排列奇数和偶数
     * 时间复杂度( O(n) )
     * 空间复杂度( O(n) ) 因为使用了临时数组作为缓存
     *
     * @param array 待排序数组
     */
    public void reArrangeInOrder1(int[] array) {
        int[] tmpArray = new int[array.length];
        int j = 0;
        //先排奇数
        for (int k : array) {
            if (!isEven(k)) {
                tmpArray[j++] = k;
            }
        }
        //再排序偶数
        for (int k : array) {
            if (isEven(k)) {
                tmpArray[j++] = k;
            }
        }
        //合并奇数和偶数
        System.arraycopy(tmpArray, 0, array, 0, array.length);
    }

    public void reArrangeInOrder2(int[] array) {
        System.out.println("array = " + Arrays.toString(array));
        int i, j, k;
        int tmp;

        for (i = 0; i < array.length; i++) {
            if (isEven(array[i])) {
                break;
            }
        }
        for (j = i + 1; j < array.length; j++) {
            if (!isEven(array[j])) {
                tmp = array[j];
                for (k = j - 1; k >= i; k--) {
                    array[k + 1] = array[k];
                }
                array[i] = tmp;
                i = i + 1;
            }
        }
    }
}
