package 数组;

import java.util.HashMap;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/two-sum/
 * @Date 2020/4/4 17:30
 */
public class _1_两数之和 {

    // 解法1：哈希表遍历法：
    // 首先计算出可以和当前索引指向的值匹配的解的值
    // 再使用哈希表去查找计算出的值 查到则返回该值的索引 查不到就加入到哈希表中
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int numNeed = target - nums[i];
            if (map.containsKey(numNeed)) {
                return new int[]{map.get(numNeed),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }

    // 解法2:暴力破解
}
