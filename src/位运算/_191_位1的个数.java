package 位运算;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/number-of-1-bits/
 * @Date 2020/10/21 11:47
 */
public class _191_位1的个数 {
    /**
     * 解法1：循环和位移动
     * 一共有32位，我们让每位值与1，统计不等于0的次数
     */
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) == 1) count++;
            mask <<= i;
        }
        return count;
    }

    /**
     * 解法2：位运算技巧
     * 在二进制表示中，数字 n 中最低位的 1 总是对应 n - 1 中的 0 。因此，将 n 和 n - 1 与运算总是能把 n 中最低位的 1 变成 0 ，并保持其他位不变。
     */
    public int hammingWeight2(int n) {
        int count = 0;
        while (n!=0){
            count++;
            n &=(n-1);
        }
        return count;
    }
}
