package 树;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/maximum-binary-tree/
 * @Date 2020/6/6 11:54
 */
public class _654_最大二叉树 {

    /**
     * 递归
     * 每次都从[
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        if (nums.length == 1) return new TreeNode(nums[0]);
        return constructMaximumBinaryTree(nums, 0, nums.length);
    }

    /**
     * 递归
     * 在[left,right)范围内构建最大二叉树
     * 每次都在[left,right)找出最大值，然后以最大值为根节点，构建左右子树。
     * 递归出口是 当left==right,说明左右两边都没有节点了，即没有左右节点。
     */
    private TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
        if (left == right) return null;
        int maxIdx = left;

        for (int i = left + 1; i < right; i++) {
            maxIdx = nums[i] > nums[maxIdx] ? i : maxIdx;
        }
        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = constructMaximumBinaryTree(nums, left, maxIdx);
        root.right = constructMaximumBinaryTree(nums, maxIdx + 1, right);
        return root;
    }


    /**
     * 对最大二叉树做个变种，求数组对应的最大二叉树形式的父节点索引值
     * 单调栈
     */
    public int[] parentIndexes(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        /**
         * 1.扫描所有元素
         * 2.保证栈底到栈顶是从大到小的
         */
        // 左边第一个比nums[i]大的数的索引
        int[] lis = new int[nums.length];
        // 右边第一个比nums[i]大的数的索引
        int[] ris = new int[nums.length];
        // 初始化两个数组
        for (int i = 0; i < nums.length; i++) {
            lis[i] = ris[i] = -1;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                // 弹出栈的元素设置右边第一个大的数的索引
                ris[stack.pop()] = i;
            }
            if (!stack.isEmpty()) {
                lis[i] = stack.peek();
            }
            stack.push(i);
        }

        int[] pis = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (lis[i] == -1 && ris[i] == -1) {
                // 根节点的父节点索引值
                pis[i] = -1;
            } else if (lis[i] == -1) {
                pis[i] = ris[i];
            } else if (ris[i] == -1) {
                pis[i] = lis[i];
            } else if (nums[lis[i]] < nums[ris[i]]) {
                pis[i] = lis[i];
            } else {
                pis[i] = ris[i];
            }
        }
        return pis;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        int[] res = new _654_最大二叉树().parentIndexes(nums);
        System.out.println(Arrays.toString(res));
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
