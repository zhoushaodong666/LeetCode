package 数组;

import java.lang.reflect.AnnotatedArrayType;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/pascals-triangle/
 * @Date 2020/10/20 16:46
 */
public class _118_杨辉三角 {
    /**
     * 动态规划法：
     * 根据前一个行的值计算下一行的值，很明显就是动态规划
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0) return result;

        result.add(new ArrayList<>());
        result.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            List<Integer> prevList = result.get(i-1);

            for (int j = 1; j < i; j++) {
                list.add(prevList.get(j-1) + prevList.get(j));
            }
            list.add(1);
            result.add(list);
        }
        return result;
    }
}
