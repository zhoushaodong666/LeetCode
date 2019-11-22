package 树;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/invert-binary-tree/
 * @Date 2019/11/22 20:43
 */
public class _226_翻转二叉树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 解题的根本是遍历每个节点,然后交换左右节点
    // 前序遍历
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right= tmpNode;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
