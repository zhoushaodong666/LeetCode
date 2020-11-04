package 栈_队列;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/daily-temperatures/
 * @Date 2020/9/10 15:00
 */
public class _739_每日温度 {
    /**
     * 方法1：栈
     * 该题实质找到数组右边第一个比当前位置元素大的数
     * 如果要看过几天才升温，可以用数组右边第一个大的和当前位置元素的索引相减得到
     * 最外层肯定要遍历数组，里面每次判断栈不为空的时候，栈顶元素和当前比较，当前大于栈顶就是找到。弹出栈顶元素，然后当前索引-栈顶元素索引。
     * 赋值result数组，result[栈顶元素索引] = 当前索引-栈顶元素索引
     */
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) return null;
        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int topIdx = stack.pop();
                result[topIdx] = i - topIdx;
            }
            stack.push(i);
        }
        return result;
    }

    /**
     * 方法2：倒推法
     * 从右往左遍历，i指向倒数第二个位置。
     * 开始令j=i+1
     * 1.如果T[i]<T[j]，那么就是会找到了第一个大的元素。result[i]=j-i。此次循环结束
     * 2.如果result[j]==0,那么就是右边没有比他大的元素，result[i]=0。此次循环结束
     * 3.否则j=j+value[j],回到步骤1
     */
    public static int[] dailyTemperatures2(int[] T) {
        if (T == null || T.length == 0) return null;
        int len = T.length;
        int[] result = new int[len];

        // i从倒数第二个位置开始 所以开始是数组长度-2
        for (int i = len - 2; i >= 0; i--) {
            int j = i + 1;
            // i是for循环在控制 是不会数组越界的
            // 所以这里我们控制j不数组越级即可
            while (j < len) {
                if (T[i] < T[j]) {
                    result[i] = j - i;
                    break;
                } else if (result[j] == 0) {
                    break;
                } else {
                    j = j + result[j];
                }
            }
        }
        return result;
    }
}
