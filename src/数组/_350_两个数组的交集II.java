package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author zhoushaodong
 * @Description https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 * @Date 2020/10/30 16:13
 */
public class _350_两个数组的交集II {
    /**
     * 解法1:哈希表
     * 1.将数组较大的遍历放进哈希表，记录数组出现的次数
     * 2.遍历较小的数组，如果哈希表中的次数大于0，则减1，写会哈希表，并把值添加到返回的数组中。
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return inner_intersect(nums1, nums2);
        } else {
            return inner_intersect(nums2, nums1);
        }
    }

    public int[] inner_intersect(int[] maxArr, int[] minArr) {
        HashMap<Integer, Integer> map = new HashMap<>(maxArr.length);

        int[] resultArr = new int[maxArr.length];
        int index = 0;
        for (int num : maxArr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (int num : minArr) {
            if (map.containsKey(num)) {
                int oldcount = map.get(num);
                if (oldcount > 0) {
                    map.put(num, oldcount - 1);
                    resultArr[index++] = num;
                }
            }
        }
        return Arrays.copyOf(resultArr, index);
    }

    /**
     * 解法2:排序 + 双指针
     * 1.先对2个数组进行排序
     * 2.定义2个指针分别指向2个数组的开头
     * 3.每次比较两个指针指向的两个数组中的数字，如果两个数字不相等，则将指向较小数字的指针右移一位，如果两个数字相等，将该数字添加到答案，并将两个指针都右移一位
     * 4.当至少有一个指针超出数组范围时，遍历结束。
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0, index = 0;
        int[] resultArr = new int[Math.min(length1, length2)];
        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                resultArr[index++] = nums1[index1];
                index1++;
                index2++;
            }
        }
        return Arrays.copyOf(resultArr,index);
    }

    public static void main(String[] args) {

    }
}
