package 数学;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/powx-n/
 * @Date 2020/4/7 1:04
 */
public class _50_Pow_x_n {
    public double myPow(double x, int n) {
        /**
         * 解法1：暴力法（提交超时）
         * 直接循环n次x相乘
         */
        /*
        double res = 1;
        // n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1]
        // 当n取最小值-2^31时，转成绝对值就为2^31，但是int类型最大值为2^31-1 所以int类型会溢出 所以先转成long类型
        long N = Math.abs((long)n);
        for (int i = 0; i < N; i++) {
            res*=x;
        }
        return n<0?1/res:res;
        */
        /**
         * 解法2：位运算法
         * 举例 x^11
         * 11(1011)
         * 1   0   1   1
         * x^8 x^4 x^2 x^1
         * 每次都取N的最低位 最低位为1 则乘上对应x次冥 然后N右移一位
         */
        double res = 1;
        // n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1]
        // 当n取最小值-2^31时，转成绝对值就为2^31，但是int类型最大值为2^31-1 所以int类型会溢出 所以先转成long类型
        long N = Math.abs((long) n);
        while (N != 0) {
            if ((N & 1) == 1) res *= x;
            x *= x;
            N >>= 1;
        }
        return n < 0 ? 1 / res : res;
    }
}
