package 字符串;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/valid-palindrome/
 * @Date 2020/4/4 16:47
 */
public class _125_验证回文串 {

    // 定义一个i j索引 从字符串首尾向中间遍历
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int i = 0, j = s.length() - 1;
        for (; i < j; i++, j--) {
            while (i < j && !isAlphanumeric(s.charAt(i))) i++;
            while (i < j && !isAlphanumeric(s.charAt(j))) j--;
            if (i < j && !isEqualIgnoreCase(s.charAt(i), s.charAt(j))) return false;
        }
        return true;
    }

    // 判断字符是否为字母或者数字
    private boolean isAlphanumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    private boolean isEqualIgnoreCase(char a, char b) {
        if (a >= 'A' && a <= 'Z') a += 32;
        if (b >= 'A' && b <= 'Z') b += 32;
        return a == b;
    }



}
