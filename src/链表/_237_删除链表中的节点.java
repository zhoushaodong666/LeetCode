package 链表;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * @Date 2019/11/12 19:39
 */
public class _237_删除链表中的节点 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 要删除传入的节点，我们一般都是找到前一个节点，但是这里没法找到前一个节点。
     * 我们换种思路，使用下一个节点的值来覆盖当前传入的节点。
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


}
