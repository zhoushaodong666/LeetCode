package 树;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/subtree-of-another-tree/
 * @Date 2020/11/20 9:47
 */
public class _572_另一个树的子树 {
    public static class TreeNode {
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
     * 解法1：
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) return false;
        return postSeralize(s).contains(postSeralize(t));
    }

    public String postSeralize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        postSeralize(root, sb);
        return sb.toString();
    }

    public void postSeralize(TreeNode node, StringBuilder sb) {
        if (node.left == null) {
            sb.append("#!");
        } else {
            postSeralize(node.left,sb);
        }

        if (node.right == null) {
            sb.append("#!");
        } else {
            postSeralize(node.right,sb);
        }

        sb.append(node.val).append("!");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode lNode = new TreeNode(4);
        TreeNode rNode = new TreeNode(5);
        root.left = lNode;
        root.right = rNode;
        lNode.left = new TreeNode(1);
        lNode.right = new TreeNode(2);

        _572_另一个树的子树 o = new _572_另一个树的子树();
        System.out.println(o.postSeralize(root));
    }


}
