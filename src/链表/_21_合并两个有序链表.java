package 链表;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @Date 2020/10/26 14:52
 */
public class _21_合并两个有序链表 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 解法1:递归法
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        else if (l2 == null) return l1;
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 解法2:迭代法
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode vHead = new ListNode(-1);

        ListNode prev = vHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        /**
         * 因为前面判断是l1和l2不为空，最后还剩下两种情况
         * 1.l1 和 l2都为null
         * 2.l1 和 l2其中一个为null
         *
         * 我们直接将链表末尾指向未合并完的链表即可
         */
        prev.next = l1 == null ? l2 : l1;

        return vHead.next;
    }
}
