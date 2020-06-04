package 数组;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/sort-colors/submissions/
 * @Date 2020/6/1 0:10
 */
public class _75_颜色分类 {
    /**
     * 三指针法
     * 一个标记0放置位置的zeroIndex指针
     * 一个标记2放置位置的twoIndex指针
     * 一个扫描的index指针
     * 当遇到0时，zeroIndex和index位置元素交换，并且两个指针都要加1
     * 当遇到1时，跳过，index++
     * 当遇到2时，index和twoIndex位置元素交换，然后twoIndex--，标记下一个可以放置2的位置
     */
    public void sortColors(int[] nums) {
        int zeroIndex = 0;
        int index = 0;
        int twoIndex = nums.length - 1;

        while (index <= twoIndex) {
            if (nums[index] == 0) {
                int tmp = nums[zeroIndex];
                nums[zeroIndex++] = nums[index];
                nums[index++] = tmp;
            } else if (nums[index] == 1) {
                index++;
            } else {
                int tmp = nums[twoIndex];
                nums[twoIndex--] = nums[index];
                nums[index] = tmp;
            }
        }
    }
}
