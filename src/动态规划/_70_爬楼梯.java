package 动态规划;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode/
 * @Date 2020/4/15 23:30
 */
public class _70_爬楼梯 {

    // 解法1:递归法
    public int climbStairs1(int n) {
        if (n <= 2) return n;
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    // 解法2:动态规划法
    public int climbStairs2(int n) {
        if (n <= 2) return n;
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            second = first + second;
            first = second - first;
        }
        return second;
    }


}
