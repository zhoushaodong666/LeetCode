package 字符串;

import java.util.Arrays;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/valid-anagram/
 * @Date 2020/11/20 16:20
 */
public class _242_有效的字母异位词 {

    /**
     * 解法1:排序
     * 异位词是长度相同，字母个数相同的。可以先判断字符串长度是否一致。
     * 使用排序如果生成的字符串一样，说明是字母异位词。
     */
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        if (schars.length != tchars.length) return false;

        Arrays.sort(schars);
        Arrays.sort(tchars);
        return Arrays.equals(schars, tchars);
    }

    /**
     * 解法2:哈希表
     * 异位词是长度相同，字母个数相同的。可以先判断字符串长度是否一致。
     * 由于题目中有说明字符串只包含小写字母，所以可以使用一个长度26的数组存储统计字符出现的次数。
     * 1.for循环统计每个字符个数，个数+1
     * 2.for循环统计每个字符个数，个数-1。如果遇到小于0的统计次数，说明不是异位词。
     * 3.2判断没有生效，说明是异位词
     */
    public boolean isAnagram2(String s, String t) {
        if (s == null || t == null) return false;
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        if (schars.length != tchars.length) return false;

        int[] counts = new int[26];

        // 统计字符串s字符出现次数
        for (int i = 0; i < schars.length; i++) {
            counts[schars[i] - 'a']++;
        }

        // 在字符串s统计次数结果的基础上，每次统计字符串t的一个字符减1
        for (int i = 0; i < schars.length; i++) {
            if (--counts[tchars[i] - 'a'] < 0) return false;
        }

        return true;
    }
}
