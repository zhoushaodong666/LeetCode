package 栈_队列;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author zhoushaodong
 * @Description
 * @Date 2020/6/4 14:05
 */
public class _239_滑动窗口最大值 {
    /**
     *
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) return new int[0];
        if (nums.length == 1) return nums;

        int[] maxes = new int[nums.length - k + 1];
        // 最大值的索引
        int maxIdx = 0;
        for (int i = 1; i < k; i++) {
            if (nums[i] > nums[maxIdx]) maxIdx = i;
        }

        for (int li = 0; li < maxes.length; li++) {
            // 滑动窗口右边索引
            int ri = li + k - 1;
            // maxId不在滑动窗口的合理范围内
            if (maxIdx < li) {
                // 重新求[li,ri]范围内的最大值索引
                maxIdx = li;
                for (int i = li + 1; i <= ri; i++) {
                    if (nums[i] > nums[maxIdx]) maxIdx = i;
                }

            } else if (nums[ri] >= nums[maxIdx]) { // 最大值索引在滑动窗口的合理范围内，且新加入的值大于等于num[maxIdx],更新maxIdx
                maxIdx = ri;
            }
            maxes[li] = nums[maxIdx];
        }
        return maxes;
    }

    /**
     * 双端队列
     * 时间：O(n) 空间：O(n)
     */
    public int[] maxSlidingWindow_deque(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) return new int[0];
        if (nums.length == 1) return nums;

        int[] maxes = new int[nums.length - k + 1];

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            // 只要nums[队尾]<=nums[i],就删除队尾
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            // 将i加到队尾
            deque.offerLast(i);
            // 检验窗口的索引是否合法
            int w = i - k + 1;
            if (w < 0) continue;
            // 检验队头的合法性
            if (deque.peekFirst() < w) {
                // 队头不合法（不在滑动窗口的索引范围内）
                deque.pollFirst();
            }
            // 设置滑动窗口的最大值
            maxes[w] = nums[deque.peekFirst()];

        }
        return maxes;
    }
}
