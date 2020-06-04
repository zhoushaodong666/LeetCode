package 动态规划;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/fibonacci-number/
 * @Date 2020/4/15 17:11
 */
public class _509_斐波那契数 {
    public int fib(int N) {
        if (N <= 1) return N;
        int first = 0;
        int second = 1;
        for (int i = 2; i <= N; i++) {
            second = first + second;
            first = second - first;
        }
        return second;
    }
}
