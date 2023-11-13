package org.example.algorithm.arrayandstring;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ArrayAndStringQuestion {

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
                //arrayandstring[i]是第一个偶数，将它替换成奇数，完成奇数的顺序排列
                array[i] = odd;
                //继续寻找下一个奇数，因为j是奇数，所以下一个奇数一定在j后面，没必要i = i+1，直接等于j，然后从j后面找就可以了
                i = j;
            }
        }
        //简单说：整个算法就是找到第一个偶数，以这个偶数为锚点，找到这个锚点后的第一个奇数，然后向后平移锚点到奇数之间的所有元素1个位置
        //再交换奇数和锚点的位置，以此再循环找到下一个奇数，直到所有奇数找完排序完毕，偶数的顺序已知都没有变化过，所以不需要排序
    }


    /**
     * 有序数组的两数求和
     *
     * @param array  数组
     * @param target 求和
     * @return 数组索引的列表
     */
    public List<int[]> sumOfTwoNum(int @NotNull [] array, int target) {
        List<int[]> list = new ArrayList<>();
        int first = 0;
        int second = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            //最大 + 最小都小于目标值，说明最小值太小了，first指针往右移动增加自己(因为是排序的数组，右边数字比左边大)
            if (array[first] + array[second] < target) {
                first++;
                //最大 + 最小都小于目标值，说明最小值太小了，second指针往左移动减小自己(因为是排序的数组，右边数字比左边大)
            } else if (array[first] + array[second] > target) {
                second--;
            } else {
                list.add(new int[]{first, second});
                first++;
                second--;
            }
        }
        return list;
    }

    /**
     * 求两有序数组的交集
     *
     * @param array1 数组1
     * @param array2 数组2
     * @return 交集集合
     */
    public List<Integer> intersectionOfTwoOrderArray(int @NotNull [] array1, int[] array2) {
        List<Integer> integerList = new ArrayList<>();
        int first = 0, second = 0;
        while (first < array1.length && second < array2.length) {
            // 由于是有序数组，如果array1[first] > array2[second]说明
            // array1[first]后面的所有值都大于array2[second]，
            //因此 array2[second]得向后移动才有可能与array1[first]相等
            if (array1[first] > array2[second]) {
                second++;
                //移动first的原理和和上面移动second的相同
            } else if (array1[first] < array2[second]) {
                first++;
            } else {
                integerList.add(array1[first]);
                first++;
                second++;
            }
        }
        return integerList;
    }


    /**
     * 求字符串数组的最长公共前缀
     *
     * @param strings 字符串数组
     * @return 公共字符串串
     */
    public String getLongestCommonPrefix(String[] strings) {
        String commonPrefix;
        if (strings == null) {
            throw new ArrayStoreException("数组为空");
        }
        if (strings.length == 1) {
            return strings[0];
        } else {
            commonPrefix = getCommonPrefix(strings[0], strings[1]);
            for (int i = 2; i < strings.length; i++) {
                commonPrefix = getCommonPrefix(commonPrefix, strings[i]);
            }
        }
        return commonPrefix;
    }

    /**
     * 求两个字符串的公共前缀
     *
     * @param string1 字符串1
     * @param string2 字符串2
     * @return 公共前缀
     */
    public String getCommonPrefix(String string1, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < Math.min(string1.length(), string2.length()); i++) {
            //因为是查找前缀，所以对应索引位置比较即可
            if (string1.charAt(i) == string2.charAt(i)) {
                stringBuilder.append(string1.charAt(i));
            } else {
                break;
            }
        }
        return stringBuilder.toString();
    }


    /**
     * 求两个字符串的公共子串，最多只有一个公共子串(如果有多个只取其中一个即可)
     *
     * @param str1 字符串1
     * @param str2 字符串2
     * @return 公共字符串
     */
    public String getLongestCommonSubString(String str1, String str2) {
        String longString, shortString, subString;
        if (str1.length() >= str2.length()) {
            longString = str1;
            shortString = str2;
        } else {
            longString = str2;
            shortString = str1;
        }
        int i, j;
        //外层循环为字符串的长度，逐次减小
        for (i = shortString.length(); i >= 1; i--) {
            //内层循环获取字符串的每一个子串
            for (j = 0; j <= shortString.length() - i; j++) {
                subString = shortString.substring(j, j + i);
                if (longString.contains(subString)) {
                    return subString;
                }
            }
        }
        //这个问题的关键点在于怎么获取较短字符串的所有子串
        return null;
    }

    /**
     * 求元素和为target的最小连续子数组，使用滑动窗口
     *
     * @param nums   数组
     * @param target 目标值
     * @return 返回元素的索引数组
     */
    public List<Integer> getMinConsecutiveArray(int[] nums, int target) {
        //类似选择排序的思路，从数组的第一个值开始，依次与其后面的所有值求和再同target对比
        List<Integer> integerList = null;
        int minLength = nums.length - 1;
        int sum = 0;
        int start = 0, end = -1;
        while (start < nums.length) {
            //end指针没有到数组末尾且和小于target
            if (end < nums.length - 1 && sum < target) {
                end++; //end 移动
                sum += nums[end];
            } else {
                //说明原来的最大窗口已经不满足要求，需要滑动原来的窗口，移动start
                sum -= nums[start]; //因为start要移动，所以要减掉原来的num[start]，重新求和
                start++;
            }
            if (sum >= target) {
                if (end - start + 1 < minLength) {
                    minLength = end - start + 1;
                    integerList = List.of(start, end);
                }
            }
        }
        if (minLength == nums.length + 1) {
            return null;
        }
        return integerList;
    }

}
