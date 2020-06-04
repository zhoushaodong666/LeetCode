package 链表;

import java.util.ArrayList;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/palindrome-linked-list/
 * @Date 2020/6/2 15:51
 */
public class _234_回文链表 {
    /**
     * 方法1：双指针 + 利用外部空间
     * 时间O(n) 空间O(n)
     * 将链表遍历加入动态数组中
     * 动态数组通过前后指针向中间扫描遍历，每次first++，last--。first>=last时，循环结束，返回true。中间如果有值不相等,直接返回false
     */
    public boolean isPalindrome1(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }

        // 指向动态数组的头部位置
        int first = 0;
        // 指向动态数组的尾部位置
        int last = list.size() - 1;
        // first >= last退出，代表是回文链表
        while (first < last) {
            if (!list.get(first++).equals(list.get(last--))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 方法2 双指针 + 部分反转
     * 时间O(n) 空间O(1)
     * 将中间位置后面的全部反转
     * 一个指针指向链表开头
     * 一个指针指向中间位置后面反转后的链表头
     * 从两端向中间扫描，如果遇到值不相等直接false，如果反转的链表指针为null，则代表是回文填表，返回true
     */
    public boolean isPalindrome2(ListNode head) {
        // 只有0个或1个节点的情况
        if (head == null || head.next == null) return true;
        // 只有2个节点的情况
        if (head.next.next == null) return head.val == head.next.val;

        // 找到中间节点
        ListNode mid = middleNode(head);
        // 反转链表中间节点之后的部分
        ListNode rHead = reverse(mid.next);
        ListNode lHead = head;
        while (rHead != null) {
            if (lHead.val != rHead.val) return false;
            lHead = lHead.next;
            rHead = rHead.next;
        }
        return true;
    }

    /**
     * 反转链表
     */
    private ListNode reverse(ListNode head) {
        if (head.next == null) return head;
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 快慢指针
     * 返回中间节点
     * 1->2->3 返回2
     * 1->2->3->4 返回2
     */
    private ListNode middleNode(ListNode head) {
        ListNode slowNode = head, fastNode = head;

        while (fastNode.next != null && fastNode.next.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return slowNode;

    }

    public  class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
