package 数组;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/merge-sorted-array/
 * @Date 2020/5/31 23:36
 */
public class _88_合并两个有序数组 {
    /**
     * 三指针法 + 归并排序中合并的思想
     * 用i1指针指向nums1数组的有效长度(不包括nums1预留给nums2的)最后一个位置
     * 用i2指针指向nums2数组的最后一个位置
     * 用cur指针指向nums数组的最后一个位置
     * nums1[i1]和nums[i2]比较，将大的数放到nums1[cur],然后cur--,比较大的那个索引要-1
     * 只要i2下标还是合法的，说明nums2中还存在元素，就循环继续
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = m - 1;
        int i2 = n - 1;
        int cur = nums1.length - 1;

        while (i2 >= 0) {
            if (i1 >= 0 && nums2[i2] < nums1[i1]) {
                nums1[cur--] = nums1[i1--];
            } else {
                // i1<0 || nums1[i1]>= nums2[i2]
                nums1[cur--] = nums2[i2--];
            }
        }
    }
}
