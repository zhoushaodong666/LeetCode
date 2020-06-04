package 数学;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/palindrome-number/
 * @Date 2020/4/13 12:48
 */
public class _9_回文数 {

    /**
     * 解法1：双指针法
     * 将整形变为字符串数组 然后前后比较
     */
    public static boolean isPalindrome1(int x) {

        char[] chs = (x + "").toCharArray();
        int len = chs.length;
        int begin = 0;
        int tail = len - 1;
        while (begin < tail) {
            if (chs[begin++] != chs[tail--]) return false;
            int i = 0;
        }
        return true;
    }

    /**
     * 解法2：数学法
     * 反转一半数字
     * 对于数字 1221，如果执行 1221 % 10，我们将得到最后一位数字 1，
     * 要得到倒数第二位数字，我们可以先通过除以 10 把最后一位数字从 1221 中移除，1221 / 10 = 122，
     * 再求出上一步结果除以 10 的余数，122 % 10 = 2，就可以得到倒数第二位数字。
     * 如果我们把最后一位数字乘以 10，再加上倒数第二位数字，1 * 10 + 2 = 12，就得到了我们想要的反转后的数字。
     * 如果继续这个过程，我们将得到更多位数的反转数字。
     *
     */
    public static boolean isPalindrome2(int x) {
        // 负数不是回文数
        // x取余为0 但x不为0 肯定不是回文数
        if (x < 0 || x % 10 == 0 && x != 0) return false;

        int revetedNumber = 0;
        while (x > revetedNumber) {
            revetedNumber = revetedNumber * 10 + x % 10;
            x /= 10;
        }
        // x == revetedNumber是偶数情况
        // x == revetedNumber / 10是奇数情况 当运行到这步时revetedNumber的最低位就是x的中位数，我们除以10就除去最低位了
        return x == revetedNumber || x == revetedNumber / 10;

    }

}
