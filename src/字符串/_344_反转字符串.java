package 字符串;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/reverse-string/
 * @Date 2020/10/20 16:31
 */
public class _344_反转字符串 {
    /**
     * 双指针法
     * 头尾交换,只使用一个变量存临时值
     */
    public void reverseString(char[] s) {
        int len = s.length;
        int left = 0, right = len - 1;
        char tmp;
        for (left = 0; left < right; left++, right--) {
            tmp = s[right];
            s[right] = s[left];
            s[left] = tmp;
        }
    }
}