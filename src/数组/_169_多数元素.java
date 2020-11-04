package 数组;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/majority-element/
 * @Date 2020/10/22 14:05
 */
public class _169_多数元素 {
    /**
     * 解法1:哈希表
     * 将数字作为键,出现次数作为值。
     * 最后遍历一遍哈希表,找到最大的次数的键即可。这个最大次数也可用一个变量存储，省去遍历一遍哈希表的过程
     */
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length <= 2) return nums[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxKey = 0;
        int maxValue = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                int times = map.get(num) + 1;
                map.put(num, times);
                if (times > maxValue) {
                    maxValue = times;
                    maxKey = num;
                } else if (maxValue > nums.length / 2) {
                    maxKey = num;
                    break;
                }
            } else {
                map.put(num, 1);
            }
        }
        return maxKey;
    }

    /**
     * 解法2:排序
     * 如果将数组 nums 中的所有元素按照单调递增或单调递减的顺序排序，那么下标为 length/2 的元素（下标从 0 开始）一定是众数。
     * 如果数组长度为奇数,那么排序完length/2位置的下班一定是众数
     * 如果数组长度为偶数,那么排序完length/2和length/2-1位置的下班一定是众数
     * 综合上述两种情况，他们在length/2位置重叠，所以我们取length/2位置为众数
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 解法3:分治
     * 将区间分为左右，分别找到左右区间中的众数
     * 当区间内，只有一个数时，则返回这个数
     * 如果左右区间的值为同一个数，就返回左区间或右区间的值
     * 如果不为同一个数，则分别计算左右区间值的个数，返回个数更多的一个
     */
    public int majorityElement3(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    public int countInRange(int[] nums, int num, int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (nums[i] == num) count++;
        }
        return count;
    }

    public int majorityElementRec(int[] nums, int low, int high) {
        if (low == high) return nums[low];

        int mid = (high + low) >> 1;
        int leftNum = majorityElementRec(nums, low, mid);
        int rightNum = majorityElementRec(nums, mid + 1, high);

        if (leftNum == rightNum) return leftNum;

        int leftCount = countInRange(nums, leftNum, low, mid);
        int rightCount = countInRange(nums, rightNum, mid + 1, high);

        return leftCount > rightCount ? leftNum : rightNum;
    }

    /**
     * 解法4:Boyer-Moore 投票算法
     */
    public static int majorityElement4(int[] nums) {
        int count = 0;
        int condidate = 0;

        for (int num : nums) {
            if (count == 0) condidate = num;
            count += (condidate == num) ? 1 : -1;
        }

        return condidate;
    }
}
