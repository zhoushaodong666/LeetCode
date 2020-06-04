package 回溯算法;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/permutations/
 * @Date 2020/4/10 0:31
 */
public class _46_全排列 {
    /**
     * 解法1：回溯法
     * 例如 [1,2,3]的全排列
     * 先固定1，那就只能选择[2,3],再固定2那就只能选择3->[1,2,3]
     * 选择完一轮后回溯到可以选择[2,3]的状态，选择3,只剩下2->[1,3,2]
     */
    public  List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        backTrack(result, nums, new LinkedList<>());
        return result;
    }

    private  void backTrack(List<List<Integer>> result, int[] nums, LinkedList<Integer> tmp) {
        // 满足条件 到达决策树底层
        if (tmp.size() == nums.length) {
            // 添加一种新排列
            // 这里要传入一个新的引用进去 不然后边全是一个tmp的引用，全部排列都会按照最后一个重复
            // 而且当函数调用结束，局部变量会销毁，会返回空的List
            result.add(new LinkedList<>(tmp));
            return;
        }

        for (int num : nums) {
            // 排除已经选择过的
            if (tmp.contains(num)) continue;
            // 做选择
            tmp.add(num);
            // 进入下一层选择
            backTrack(result, nums, tmp);
            // 撤销选择
            tmp.removeLast();
        }
    }


    /**
     * 解法2：回溯法
     * 在解法1的基础上进行优化
     * 解法1用contains的方法的时间复杂度是O(n),我们使用交换的方法优化到O(1)
     */
    public static List<List<Integer>> permute2(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);
        backTrack2(list, 0, result);
        return result;
    }

    private static void backTrack2(List<Integer> nums, int start, List<List<Integer>> result) {
        // 结束条件
        // 到达决策树底层 也就是一组新排列
        if (nums.size() == start) {
            result.add(new ArrayList<>(nums));
            // 虽然下面的for循环会判断是否数组长度达到最大，但是这里还是return下，减少一次判断
            return;
        }

        for (int i = start; i < nums.size(); i++) {
            Collections.swap(nums, start, i);
            backTrack2(nums, start + 1, result);
            Collections.swap(nums, start, i);
        }
    }


}
