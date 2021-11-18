package 字符串;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * @Date 2020/11/21 13:51
 */
public class _151_翻转字符串里的单词 {

    /**
     * 解法1：使用语言特性的函数
     * 两边去除空格 trim()
     * 连续空格切割 split()
     * 反转切割后的数组 reverse()
     * 空格连接字符串数组 join()
     */
    public String reverseWords(String s) {
        // 两边去除空格
        s = s.trim();
        // 连续空格切割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        // 反转单词数组
        Collections.reverse(wordList);
        // 空格连接字符串数组
        return String.join(" ",wordList);
    }

    /**
     * 解法2:自行编写对应的函数
     */
    public static String reverseWords2(String s) {
        char[] chars = s.toCharArray();

        int cur = 0;
        boolean space = true;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                chars[cur++] = chars[i];
                space = false;
            } else if (!space) {
                chars[cur++] = ' ';
                space = true;
            }
        }

        int len = space ? cur - 1 : cur;

        reverse(chars, 0, len);
        return new String(chars, 0, len);
    }

    /**
     * 将[li,ri)范围内的字符串反转
     */
    private static void reverse(char[] chars,int li,int ri){
        // ri真正可以修改的位置是小于ri的，所以先减1
        ri--;
        while (li < ri) {
            char tmp = chars[li];
            chars[li++] = chars[ri];
            chars[ri--] = tmp;
        }

    }

    public static void main(String[] args) {
        System.out.println(reverseWords2("timi so good  "));
        reverseWords2("  i  love  you  ");
    }


}
