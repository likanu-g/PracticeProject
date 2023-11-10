package org.example.algorithm.string;

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
}
