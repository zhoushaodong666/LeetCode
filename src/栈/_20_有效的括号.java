package 栈;

import java.util.Stack;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/valid-parentheses/
 * @Date 2019/11/16 15:25
 */
public class _20_有效的括号 {

    // 方法1：使用栈
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char c[] = s.toCharArray();
        int len = c.length;
        for (int i = 0; i < len; i++) {
            // 左括号
            if(c[i]=='('||c[i]=='['||c[i]=='{'){
                stack.push(c[i]);
            }else{
                // 右括号
                // 判断栈是不是为空 为空则不是有效
                if(stack.isEmpty())return false;
                // 弹出栈顶元素与右括号比较
                char left = stack.pop();
                if(left=='('&&c[i]!=')')return false;
                if(left=='['&&c[i]!=']')return false;
                if(left=='{'&&c[i]!='}')return false;
            }
        }
        return stack.isEmpty();
    }


    // 方法2：使用java自带的字符串查找替换，简单粗暴，就是效率低
    public boolean isValid2(String s) {
        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            s = s.replace("()", "");
            s = s.replace("[]", "");
            s = s.replace("{}", "");
        }
        return s.isEmpty();
    }
}
