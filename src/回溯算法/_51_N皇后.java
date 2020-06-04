package 回溯算法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/n-queens/
 * @Date 2020/4/19 13:09
 */
public class _51_N皇后 {
    List<List<String>> result = new LinkedList<>();

    // 记录摆放皇后的位置
    int []queens;
    // 记录某列是否有皇后
    boolean cols;
    // 左上角->右下角斜线是否有摆放皇后
    int []leftTop;
    // 右上角->左下角斜线是否有摆放皇后
    int []rightTop;

    public List<List<String>> solveNQueens(int n) {
        LinkedList<String> tmpList = new LinkedList<>();
        if (n <= 1) {
            result.add(tmpList);
            return result;
        }
        place(n, 0);
        return result;
    }

    public void place(int n, int row) {
        // 递归结束条件
        if (row == n) {
            return;
        }
        // 选择一个

        // 选择下一个
        // 重置状态
    }

    public void addResult(){

    }


}
