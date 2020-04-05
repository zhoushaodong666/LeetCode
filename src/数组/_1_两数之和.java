package 数组;

import java.util.HashMap;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/two-sum/
 * @Date 2020/4/4 17:30
 */
public class _1_两数之和 {
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
}
