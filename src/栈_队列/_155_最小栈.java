package 栈_队列;

import java.util.Stack;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/min-stack/
 * @Date 2020/6/4 11:04
 */
public class _155_最小栈 {
    /**
     * 方法1：辅助栈
     * 增加一个栈来存储对应正常栈的最小值
     * 例如,
     * 正常栈：2->5->3->1->8
     * 辅助栈：2->2->2->1->1
     */
    // 正常栈
    Stack<Integer> stack;
    // 最小栈
    Stack<Integer> minStack;

    public _155_最小栈() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            minStack.push(Math.min(x,minStack.peek()));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
