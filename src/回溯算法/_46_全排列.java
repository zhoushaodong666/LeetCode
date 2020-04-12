package 回溯算法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author zhoushaodong
 * @Description
 * @Date 2020/4/10 0:31
 */
public class _46_全排列 {


    /**
     * 解法1：回溯法
     * 例如 [1,2,3]的全排列
     * 先固定1，那就只能选择[2,3],再固定2那就只能选择3->[1,2,3]
     * 选择完一轮后回溯到可以选择[2,3]的状态，选择3,只剩下2->[1,3,2]
     */
    /*
    public  List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        backTrack(result, nums, new LinkedList<>());
        return result;
    }

    private  void backTrack(List<List<Integer>> result, int[] nums, LinkedList<Integer> tmp) {
        // 满足条件
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
*/

    /**
     * 解法2：回溯法
     * 在解法1的基础上进行优化
     *
      */



}
