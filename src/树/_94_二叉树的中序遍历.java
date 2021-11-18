package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * @Date 2021/11/18 16:24
 */
public class _94_二叉树的中序遍历 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 解法1:递归
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Recursion(root, list);

        return list;
    }

    private void Recursion(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        // 左节点
        Recursion(node.left, list);
        // 当前节点
        list.add(node.val);
        // 右节点
        Recursion(node.right, list);

    }

    /**
     * 解法2:迭代
     * 递归隐式的维护了一个栈，采用迭代法需要显示的维护一个栈
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                // 根节点入栈
                stack.push(root);
                // 寻找左节点
                root = root.left;
            }
            // 根节点出栈
            TreeNode popNode = stack.pop();
            //
            list.add(popNode.val);
            // 寻找右节点
            root = popNode.right;
        }
        return list;
    }


}
