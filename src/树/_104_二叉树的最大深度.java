package 树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * @Date 2020/10/20 15:39
 */
public class _104_二叉树的最大深度 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 解法1：递归
     * 如果我们知道了左子树和右子树的最大深度 ll 和 rr，那么该二叉树的最大深度即为 max(l,r) + 1
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 解法2：迭代的BFS
     * 计算BFS的层级，最后一层就是最大深度
     */

    public static int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        int maxHeight = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 记录层数
            maxHeight++;
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                size--;
            }
        }

        return maxHeight;
    }
}
