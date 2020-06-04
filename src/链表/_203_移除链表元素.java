package 链表;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/remove-linked-list-elements/
 * @Date 2020/6/1 11:04
 */
public class _203_移除链表元素 {
    /**
     * 头节点
     */
    public ListNode removeElements(ListNode head, int val) {
        // 处理head==val情况
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) return null;
        // 处理head!=val，即中间节点等于val的情况
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    /**
     * 虚拟头节点
     */
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) return null;
        ListNode newHead = new ListNode(0);
        ListNode newTail = newHead;
        while (head != null) {
            if (head.val != val) {
               newTail.next = head;
               newTail = head;
            }
            head = head.next;
        }
        newTail.next = null;
        return newHead.next;
    }


    public  class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
