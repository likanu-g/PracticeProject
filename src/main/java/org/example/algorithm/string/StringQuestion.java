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

    /**
     * 按照顺序左右排列奇数和偶数
     * 时间复杂度 O(n^2)
     * 空间复杂度O(1) 在原数组上操作数组，没有开辟新的空间
     *
     * @param array 待排序数组
     */
    public void reArrangeInOrder2(int[] array) {
        int i, j, k;
        int odd;

        for (i = 0; i < array.length; i++) {
            //找到第一个出现的偶数的索引
            if (isEven(array[i])) {
                break;
            }
        }
        for (j = i + 1; j < array.length; j++) {
            //找到第一个偶数后面的第一个奇数
            if (!isEven(array[j])) {
                //找到奇数
                odd = array[j];
                //将第一个偶数到奇数之间的所有数向后平移1
                for (k = j - 1; k >= i; k--) {
                    array[k + 1] = array[k];
                }
                //array[i]是第一个偶数，将它替换成奇数，完成奇数的顺序排列
                array[i] = odd;
                //继续寻找下一个奇数，因为j是奇数，所以下一个奇数一定在j后面，没必要i = i+1，直接等于j，然后从j后面找就可以了
                i = j;
            }
        }
        //简单说：整个算法就是找到第一个偶数，以这个偶数为锚点，找到这个锚点后的第一个奇数，然后向后平移锚点到奇数之间的所有元素1个位置
        //再交换奇数和锚点的位置，以此再循环找到下一个奇数，直到所有奇数找完排序完毕，偶数的顺序已知都没有变化过，所以不需要排序
    }
}
