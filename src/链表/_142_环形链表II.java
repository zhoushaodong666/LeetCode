package 链表;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * @Date 2020/11/23 21:49
 */
public class _142_环形链表II {

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
     * 两个指针走到步幅不一样,如果链表有环,快慢指针终会指向同一个节点
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        ListNode fast = head, slow = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                return fast;
            }
        }
        return null;
    }

    /**
     * 哈希表法：
     * 使用哈希表存储之前走过的节点,每次都判断该节点是否走过
     */
    public ListNode detectCycle1(ListNode head) {
        ListNode pos = head;
        Set<ListNode> set = new HashSet<>();
        while (pos != null) {
            if (set.contains(pos)) {
                return pos;
            } else {
                set.add(pos);
                pos = pos.next;
            }
        }
        return null;
    }

}
