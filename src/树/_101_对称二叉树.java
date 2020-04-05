package 树;


import java.util.Stack;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/symmetric-tree/
 * @Date 2020/4/5 11:30
 */
public class _101_对称二叉树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 解法1：递归法
    public boolean isSymmetricByRecursive(TreeNode root) {
        if (root == null) return true;
        return isSymmetri(root.left, root.right);
    }

    public boolean isSymmetri(TreeNode lt, TreeNode rt) {
        if (lt != null && rt != null)
            return (lt.val == rt.val) &&
                    isSymmetri(lt.left, rt.right) && isSymmetri(lt.right, rt.left);
        else return lt == null && rt == null;
    }

    // 解法2：迭代法
    // 使用一个栈来存储左右子树节点 每次取出2个节点比较
    // 然后再依次入栈第一个节点的左子树节点 第二个节点的右子树节点 第二个节点的左子树节点 第二个节点的右子树节点
    public boolean isSymmetricByIterative(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root.left);
        stack.add(root.right);
        while (!stack.isEmpty()) {
            TreeNode lt = stack.pop();
            TreeNode rt = stack.pop();
            // 两个子树节点都为null 循环下一轮
            if (lt == null && rt == null) continue;
            // 有一个null 一个不为null 不对称
            if (lt == null || rt == null) return false;
            // 两个节点都不为null 比较两个节点的值是否相等
            if (lt.val != rt.val) return false;
            // 两个节点值都相等
            // 依次将两个节点 按照相反方向入栈
            stack.push(lt.left);
            stack.push(rt.right);
            stack.push(rt.left);
            stack.push(lt.right);
        }
        // 栈空了 说明对称
        return true;
    }
}
