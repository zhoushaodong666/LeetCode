package 树;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * @Date 2020/10/21 10:27
 */
public class _108_将有序数组转换为二叉搜索树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * 解法：递归 + 中序遍历 + 选择中间靠左作为根节点
     * 题目给定的数组是按照升序排序的有序数组，因此可以确保数组是二叉搜索树的中序遍历序列
     * 因为要保持高度差不超过1，,所以选择中间节点。
     * 中间节点的选择可以有3种，这里采用第1种
     * 1.中间靠左
     * 2.中间靠右
     * 3.中间随机选择左右一个
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) return null;

        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) >> 1;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = sortedArrayToBST(nums, left, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, right);

        return root;
    }

}
