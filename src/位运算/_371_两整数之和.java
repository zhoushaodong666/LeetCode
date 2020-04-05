package 位运算;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/sum-of-two-integers/
 * @Date 2020/4/5 13:37
 */
public class _371_两整数之和 {
    // 举例 5+7=12 5(101) 7(111) 低位2 + 进位10 = 12
    // 第一步：异或运算 5^7 = 101^111 = 010 = 2
    // 第二步：与运算 5&7 = 101&111 = 101 再左移1位得到 101 << 1 = 1010 = 6
    // 第三步：重复上面2步，010^1010 = 1000 (010&1010)<<1 = 100
    // 继续重复 1000^100 = 1100 (1000&100)<<1 = 0 进位为0就不再重复 1100就是最终的结果
    public int getSum(int a, int b) {
        // 解法1：递归法
//        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);

        // 解法2：迭代法
        while (b != 0) {
            int sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return a;
    }
}
