package 链表;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/linked-list-cycle/
 * @Date 2019/11/12 21:13
 */
public class _141_环形链表 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 快慢指针：
     * 慢指针走的慢点，快指针走的快点。
     * 好像两个人在操场跑步，一个跑的慢，一个跑的快，一直跑，迟早相遇，相遇代表有环。
     */
    public boolean hasCycle(ListNode head) {
        // 边界条件：0或1个节点是没有环的
        if (head == null || head.next == null) return false;
        ListNode slowNode = head;
        ListNode fastNode = head.next;
        // 快指针为空和快指针的下一个节点为空都退出循环
        while (fastNode != null && fastNode.next != null) {
            // 相等即有环
            if (slowNode == fastNode) return true;
            // 慢指针的步幅为1
            slowNode = slowNode.next;
            // 快指针的步幅为2
            fastNode = fastNode.next.next;
        }
        return false;
    }
}
