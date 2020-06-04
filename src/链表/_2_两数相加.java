package 链表;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/add-two-numbers/
 * @Date 2020/6/2 0:18
 */
public class _2_两数相加 {
    /**
     * 数学法
     * 一个指向l1的指针
     * 一个指向l2的指针
     * 一个记录进位值的变量carry
     * 遍历两个链表，直到两个链表都为null
     * 每次两个链接的节点值相加，再加上carry的进位值，得出sum，再计算进位情况，如果进位，创建的节点是sum的个位数，即取余10的得到（12%10=2）
     * 循环结束后，还要判断最后一次carry的进位情况，再决定是否追加节点
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummyHead = new ListNode(0);
        ListNode last = dummyHead;
        // 进位值
        int carry = 0;
        while (l1 != null || l2 != null) {
            int v1 = 0;
            if (l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            }

            int v2 = 0;
            if (l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            }
            int sum = v1 + v2 + carry;
            // 设置进位值
            carry = sum / 10;
            // 节点存储sum的个位数 假如是12，应该存成2
            last.next = new ListNode(sum % 10);
            // 重新指向最后一个节点
            last = last.next;
        }
        // 检查最后的进位
        if (carry > 0) {
            last.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
