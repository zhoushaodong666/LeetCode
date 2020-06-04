package 链表;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * @Date 2020/6/2 1:06
 */
public class _160_相交链表 {
    /**
     * 双指针 + 链表拼接
     * 一个指针curA用来指向headA链表遍历的位置
     * 一个指针curB用来指向headB链表遍历的位置
     * 当curA为null时，指向headB的头部
     * 当curB为null时，指向headA的头部
     * 这样就相等于我们两个人在跑道以相同速度上赛跑，如果有相同的终点就会一起到达终点，则相交，反之则不相交
     * 如果链表相交，走的路程相同，curA和curB肯定会在第一个相交点相等
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode curA = headA;
        ListNode curB = headB;

        while (curA != curB) {
            curA = (curA == null) ? headB : curA.next;
            curB = (curB == null) ? headA : curB.next;
        }
        return curA;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
