package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * @Date 2020/10/30 14:21
 */
public class _349_两个数组的交集 {

    /**
     * 解法1：2个set
     * 将2个数组遍历转化成2个set集合，再遍历小的set集合，看在大的set中是否与相同元素
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[]{};

        HashSet<Integer> set1 = new HashSet<>(nums1.length);
        HashSet<Integer> set2 = new HashSet<>(nums2.length);
        for (int i : nums1) {
            set1.add(i);
        }

        for (int i : nums2) {
            set2.add(i);
        }

        if (nums1.length > nums2.length) {
            return set_intersection(set2, set1);
        } else {
            return set_intersection(set1, set2);
        }

    }

    public int[] set_intersection(Set<Integer> set1, Set<Integer> set2) {
        int[] arr = new int[set1.size()];
        System.out.println(Arrays.toString(arr));
        int index = 0;
        for (Integer k : set1) {
            if (set2.contains(k)) arr[index++] = k;
        }

        return Arrays.copyOf(arr, index);
    }


}
