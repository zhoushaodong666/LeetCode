package 其它;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/fizz-buzz/
 * @Date 2020/10/21 15:46
 */
public class _412_Fizz_Buzz {

    /**
     * 解法1:模拟法
     * 就是按照题目的意思去判断，判断步骤：
     * 1.先判断能否被3和5整除，能就假如FizzBuzz到列表
     * 2.再判断能否被3整除，能就假如Fizz到列表
     * 3.先判断能否被5整除，能就假如Buzz到列表
     * 4.最后添加数字到列表
     */
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        if (n == 0) return list;


        for (int i = 1; i <= n; i++) {
            boolean deived3 = (i % 3 == 0);
            boolean deived5 = (i % 5 == 0);

            if (deived3 && deived5) list.add("FizzBuzz");
            else if (deived3) list.add("Fizz");
            else if (deived5) list.add("Buzz");
            else list.add(i + "");
        }
        return list;
    }

    /**
     * 解法2:字符串拼接
     * 这个方法不会降低渐进复杂度，但是当 FizzBuzz 的规则变得更复杂的时候，这将会是个更优雅的解法
     * 我们放弃使用之前的联合判断，取而代之依次判断是否能被给定的数整数。
     * 算法：
     * 这道题中，就是依次判断能不能被 3 整除，能不能被 5 整除。如果能被 3 整除，就把对应的 Fizz 连接到答案字符串，
     * 如果能被 5 整除，就把 Buzz 连接到答案字符串。
     */
    public List<String> fizzBuzz2(int n) {
        List<String> list = new ArrayList<>();
        if (n == 0) return list;

        for (int i = 1; i <= n; i++) {
            boolean deived3 = (i % 3 == 0);
            boolean deived5 = (i % 5 == 0);
            String ansStr = "";

            if (deived3) ansStr += "Fizz";
            if (deived5) ansStr += "Buzz";
            if (ansStr == "") ansStr = i + "";

            list.add(ansStr);
        }
        return list;
    }

    /**
     * 解法3:哈希表
     * 这个方法是对方法二的优化。当数字和答案的映射是定好的，那么方法二用起来也还可以。但是如果你遇到一个变态的面试官，他跟你说他需要更自由的映射关系呢？
     * 每个映射一个判断显然是不可行的，这样写出来的代码一定是丑陋不堪且难以维护的。
     * 如果老板有这样一个需求，明天你把映射关系换掉或者删除一个映射关系吧。对于这种要求，我们只能一个个去修改判断条件的代码。
     * 但我们实际上有个更优雅的做法，那就是把映射关系放在"哈希表"里面
     * 哈希表应该是这样{ 3: 'Fizz', 5: 'Buzz', 7: 'Jazz' }
     */
    public List<String> fizzBuzz3(int n) {
        List<String> list = new ArrayList<>();
        if (n == 0) return list;
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(3, "Fizz");
        map.put(5, "Buzz");

        for (int i = 1; i <= n; i++) {
            String ansStr = "";

            for (Integer key : map.keySet()) {
                if (i % key == 0) ansStr += map.get(key);
            }
            if (ansStr == "") ansStr = i + "";

            list.add(ansStr);
        }
        return list;
    }
}
