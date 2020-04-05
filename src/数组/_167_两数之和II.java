package 数组;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * @Date 2020/4/4 22:05
 */
public class _167_两数之和II {
    // 解法1：二分法
    // 先通过当前索引的元素，计算出需要的元素，再用二分法查找这个需要的元素
    public int[] twoSum(int[] numbers, int target) {
        int index = 0, left, right = numbers.length - 1;
        // 遍历，界限为right
        for (; index < right; index++) {
            int temp = target - numbers[index];
            // 如果当前值和最大值之和小于target，跳过，继续下一轮循环
            if (numbers[index] + numbers[right] < target) {
                continue;
            }
            left = index + 1;
            // 查找，找到就返回，未找到就更新right
            while (left <= right) {
                int mid = (left + right) >> 1;
                // 找到并返回
                if (numbers[mid] == temp) {
                    return new int[]{index + 1, mid + 1};
                }
                // 二分
                if (numbers[mid] < temp) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        // 题目限定必然有一组解，此处不会出现 但是还是给个返回值
        return new int[]{-1, -1};
    }

    // 解法2：双指针法
    // 通过2个指向数组首尾的指针，向中间遍历，直到头部指针索引不在小于尾部指针索引
    public static int[] twoSumBy2Pointer(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        int sum = 0;
        while (i < j) {
            // 计算两个指针指向的元素值的和
            sum = numbers[i] + numbers[j];
            // 两数之和小于target 头部指针向右移动一位 因为升序数组 右边的数更大
            if (sum < target) i++;
            // 两数之和大于target 尾部指针向左移动一位 因为升序数组 左边的数更小
            else if (sum > target) j--;
            // 前面两种情况排除 只剩下两数之和等于target的情况 就是我们要的解
            // 因为题目中说到索引不从0开始 所以我们要在真实索引的基础上+1
            else return new int[]{i+1,j+1};
        }
        // 题目必有解 所以一定不回执行这句代码 但是还是给个返回值
        return new int[]{-1,-1};
    }
}
