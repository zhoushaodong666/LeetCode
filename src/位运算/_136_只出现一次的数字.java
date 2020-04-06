package 位运算;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/single-number/
 * @Date 2020/4/6 2:20
 */
public class _136_只出现一次的数字 {

    public static int singleNumber(int[] nums) {
        /*

        解法1：哈希表法
        将数组元素出现的次数存到map中 在查找次数为1的  就是解
         */

//        HashMap<Integer, Integer> map = new HashMap();
//        for (int i = 0; i < nums.length; i++) {
//            Integer v = map.get(nums[i]);
//            if (v == null) {
//                map.put(nums[i], 1);
//            } else {
//                map.put(nums[i], 2);
//            }
//        }
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue() == 1) return entry.getKey();
//        }
//        return -1;

        /*
         解法2：数学法
         2∗(a+b+c)−(a+a+b+b+c)=c
         将数组元素都存储到set集合中，遍历set集合
         set集合的特点是不能存储重复的元素，也就是重复的只会存储1次
         x代表数组中所有元素的和 y代表set集合中所有元素的和 解就为2y-x
         */
//        HashSet<Integer> set = new HashSet<>();
//        int setSum = 0,arraySum = 0;
//        for (int num : nums) {
//            if (!set.contains(num)) {
//                setSum += num;
//                set.add(num);
//            }
//            arraySum += num;
//        }
//        return 2 * setSum - arraySum;

        /*
          解法3：异或运算法
          异或运算是相同为0，不同为1
          例如 5^5=0 5^5^6=6 5(101) 6(110)
              _____   _____
              101       101
              101       101
              _____   _____
              000       000
                        110
                      _____
                        110 = 6
          根据异或运算，将每个数都进行异或，得到最后结果就是只出现一次的数
         */
//        int res = 0;
//        for (int num : nums) {
//            res ^= num;
//        }
//        return res;
        // 解法4：排序法
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len-1; i+=2) {
            if(nums[i]!=nums[i+1]){
                return nums[i];
            }
        }
        return nums[len-1];
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 1}));
    }
}
