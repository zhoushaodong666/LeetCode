package 树;

import java.util.Stack;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/same-tree/
 * @Date 2020/4/6 23:17
 */
public class _100_相同的树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        /**
         * 解法1：递归法
         * 比较2个节点值和和它的左右节点
         */
//        if (p == null && q == null) return true;
//        if (p == null || q == null) return false;
//        return p.val==q.val&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);

        /**
         * 解法2：迭代法
         * 每次把两棵树对应位置的节点添加进栈中
         * 再每次取出两个比较是否相等
         */

        Stack<TreeNode> stack = new Stack<>();
        stack.push(p);
        stack.push(q);
        while (!stack.isEmpty()) {
            TreeNode s1 = stack.pop();
            TreeNode s2 = stack.pop();
            if (s1 == null && s2 == null) continue;
            if (s1 == null || s2 == null) return false;
            if(s1.val!=s2.val) return false;

            stack.push(s1.left);
            stack.push(s2.left);
            stack.push(s1.right);
            stack.push(s2.right);
        }
        return true;
    }


}
