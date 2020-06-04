package 链表;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/reverse-linked-list/
 * @Date 2019/11/12 19:48
 */
public class _206_反转链表 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    /**
     * 方法1：递归
     * 递归到最后一个，然后返回，
     * 用下一个节点的next指向当前节点，完成反转
     * 还有将当前节点的next指向置为null，防止循环指向
     */
    public ListNode reverseList(ListNode head) {
        // 终止条件：节点只有0或者1个的时候退出
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        // head节点的下一个节点的next域指向head，完成反转
        // 那么head节点这是已经是最后一个节点了，那么head节点的next域还要指向null
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    // 方法2：迭代
    public ListNode reverseList2(ListNode head) {
        // 边界条件：节点只有0或者1个的时候退出
        if (head == null || head.next == null) return head;
        ListNode newHead = null;
        while (head != null) {
            // 保存head节点的下一个节点
            ListNode tmp = head.next;
            // 将head指向新链表的头节点
            head.next = newHead;
            // 将新链表头节点更新
            newHead = head;
            // head指向下一个 继续迭代
            head = tmp;
        }
        return newHead;
    }
}
