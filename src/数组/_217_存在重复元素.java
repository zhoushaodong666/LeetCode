package 数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/contains-duplicate/
 * @Date 2020/10/30 13:47
 */
public class _217_存在重复元素 {

    /**
     * 解法1：哈希表法
     * 利用set集合不存储重复元素的特性
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (!set.add(x)) return true;
        }
        return false;
    }

    /**
     * 解法1：排序法
     * 将数组排序要，再比较相邻元素是否存在相等的，有相等就是有重复元素，反之就没有重复元素
     */
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }
}
