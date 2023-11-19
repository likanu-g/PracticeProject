package org.example.algorithm.arrayandstring;

import org.jetbrains.annotations.NotNull;

import java.util.*;

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

    /**
     * 求给定字符串的最长无重复子串的长度（使用滑动窗口）
     *
     * @param string
     * @return
     */
    public int getLongestNoRepeatLength(String string) {
        int start = 0;
        int end = 0;
        Set<Character> characterSet = new HashSet<>();
        int maxLength = 0;
        while (start < string.length()) {
            //如果end没有指向字符串末尾，且set中不包含end处的字符
            if (end < string.length() && characterSet.add(string.charAt(end))) {
                //每次移动完end指针，将最大长度与maxLength比较
                if (end - start + 1 > maxLength) {
                    maxLength = end - start + 1;
                }
                // 移动end指针
                end++;
            } else { //end指针已经到了字符串末尾或者字符已经存在于set中
                //说明出现了重复的字符在start位置，所以要剔除，移动start重新重复前面的操作
                characterSet.remove(string.charAt(start));
                start++;
            }
        }
        return maxLength;
    }


    /**
     * 在给定的字符数组中删除指定的字符数组中的字符，求删除所有指定字符后原字符数组剩余的字符的个数
     *
     * @param srcStr    给定的原字符数组
     * @param removeStr 删除的字符数组（没有重复字符）
     * @return 原字符数组中剩余字符的个数
     */
    public int removeChars(char[] srcStr, char[] removeStr) {
        int src = 0;
        int dst = 0;
        HashSet<Character> set = new HashSet<>();
        //将要删除的所有字符添加到hashset中
        for (char ch : removeStr) {
            set.add(ch);
        }
        for (src = 0; src < srcStr.length; src++) {
            if (set.contains(srcStr[src])) {
                //这里为什么可以这么直接赋值，是因为dst <= src,所以不会造成srcStr[src]后面的值被覆盖
                //这里的双指针用法可以延伸到netty的ByteBuf或者java的ByteBuffer
                //使用双指针作为读写指针
                srcStr[dst] = srcStr[src];
                //移动dst，这里的dst既做了字符索引又做了，元素个数的计数器
                dst++;
                set.remove(srcStr[src]);
            }
        }
        return dst;
    }


    /**
     * 求最短的连续子数组，如果这个子数组升序排列，整个数组也是升序排列
     *
     * @param array 原数组
     * @return 子数组的长度
     */
    public int getShortestConsecutiveSubArray(int[] array) {
        int[] tmpArray = Arrays.copyOf(array, array.length);
        int start = 0;
        int end = 0;
        //首先进行数组排序
        Arrays.sort(tmpArray);
        //正向找乱序的起点
        for (int i = 0; i < array.length; i++) {
            //如果同位置元素不相等，说明是乱序的
            if (array[i] != tmpArray[i]) {
                start = i;
                break;
            }
        }
        //反向找乱序的终点
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] != tmpArray[i]) {
                end = i;
                break;
            }
        }

        if (end == start && start == 0) {
            return 0;
        } else {
            return end - start + 1;
        }
    }


    /**
     * 重排字符数组中的字符，重排顺序按照字母、数字、符号的顺序排列
     *
     * @param chars 待重排数组
     */
    public void charArrayRearrange(char[] chars) {
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            //skip letters
            while (left < right && Character.isLetter(chars[left])) {
                left++;
            }
            //skip symbols, not letter or digit
            while (left < right && !Character.isLetterOrDigit(chars[right])) {
                right--;
            }
            if (left < right) {
                swap(chars, left, right);
                left++;
                right--;
            }
        }
        reverse(chars, left, chars.length - 1);
        System.out.println("chars = " + Arrays.toString(chars));

    }

    private void swap(char[] nums, int low, int high) {
        char tmp = nums[low];
        nums[low] = nums[high];
        nums[high] = tmp;
    }

    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }


    /**
     * 判断两个字符串是否互为变形词
     * 例如： "abcd"和"cadb" 是互为变形词
     *
     * @param str1 第一个字符串
     * @param str2 第二个字符串
     * @return 互为变形词返回true, 否则,返回false
     */
    public boolean isDeformation(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        } else {
            char[] chars1 = str1.toCharArray();
            char[] chars2 = str2.toCharArray();
            int[] map = new int[256];
            for (char c : chars1) {
                //遍历str1标记所有字符
                // map的key表示str1中的字符，
                // value表示该字符出现的次数
                map[c]++;
            }
            for (int i = 0; i < str2.length(); i++) {
                //map[chars2[i]]表示chars2[i] 这个字符在map中出现的次数
                //每遇到一次，次数-1
                if (map[chars2[i]]-- == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 判断字符数组中所有字符是否只出现过一次
     *
     * @param chas 字符数组
     * @return 是返回true 否返回false
     */
    public boolean isUnique(char[] chas) {
        if (chas == null) {
            return false;
        }
        boolean[] map = new boolean[256];
        for (char cha : chas) {
            if (map[cha]) {
                return false;
            }
            map[cha] = true;
        }
        return true;
    }

}
