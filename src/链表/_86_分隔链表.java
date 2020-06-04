package 链表;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/partition-list/
 * @Date 2020/6/2 14:57
 */
public class _86_分隔链表 {

    /**
     * 双指针 + 链表拼接
     * 将小于x的放到一条链表，大于等于x的放到一条链表，最后连接两条链表
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode dummyNode1 = new ListNode(0);
        ListNode dummyNode2 = new ListNode(0);
        ListNode last1 = dummyNode1;
        ListNode last2 = dummyNode2;
        while (head != null) {
            if (head.val < x) {
                last1.next = head;
                last1 = head;
            } else {
                last2.next = head;
                last2 = head;
            }
            head = head.next;
        }
        // 将第二条链表最后一个节点，右边连接的小于val的节点断开
        last2.next = null;
        // 连接两条链表
        last1.next = dummyNode2.next;
        return dummyNode1.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
