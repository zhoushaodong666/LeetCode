package 数组;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/search-a-2d-matrix/
 * @Date 2020/4/6 14:21
 */
public class _74_搜索二维矩阵 {

    // 解法1：缩小范围法
    // 从右上角开始查找
    // 根据题意 target比本行最大值小 则可以排除该列 所以列索引-1继续向左搜索
    // target比本行最大值大 则可以排除该行 所以行索引+1继续向下搜索
    // 缩小范围 逐步向左下方向查找
    public  boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 ||
                matrix[0] == null || matrix[0].length == 0) return false;
        // 行数
        int m = matrix.length;
        // 列数
        int n = matrix[0].length;
        // 行索引
        int i = 0;
        // 列索引
        int j = n - 1;

        while (i < m && j >= 0) {
            // target比本行最大值小 则可以排除该列 所以列索引-1继续向左搜索
            if (target < matrix[i][j]) j--;
                // target比本行最大值大 则可以排除该行 所以行索引+1继续向下搜索
            else if (target > matrix[i][j]) i++;
                // 前面小于大于的情况都排除了 只剩下等于的解
            else return true;
        }
        // 前面二维数组搜索完还没找到 说明target不在二维数组中
        return false;
    }

}
