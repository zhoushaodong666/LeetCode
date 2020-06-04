package 数组;

/**
 * @Author zhoushaodong
 * @Description
 * @Date 2020/6/1 10:20
 */
public class _面试题_16_16_部分排序 {
    /**
     * 双指针法
     * 一个记录最右逆序对的位置，从左往右扫描，记录下最大值，如果比最大值小，说明该位置是逆序的，记录该逆序的位置
     * 一个记录最左逆序对的位置，从右往左扫描，记录下最小值，如果比最小值大，说明该位置是逆序的，记录该逆序的位置
     */
    public int[] subSort(int[] array) {
        if (array.length <= 1) return new int[]{-1, -1};
        // 从左往右扫描（正序：逐渐变大）
        int max = array[0];
        // 记录最右的逆序对的位置
        int right = -1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= max) {
                max = array[i];
            } else {
                right = i;
            }
        }

        // 从右往左扫描（正序：逐渐变小）
        int min = array[array.length - 1];
        // 记录最左的逆序对的位置
        int left = -1;
        for (int i = array[array.length - 2]; i >= 0; i--) {
            if (array[i] <= min) {
                min = array[i];
            } else {
                left = i;
            }
        }
        return new int[]{left, right};
    }
}
