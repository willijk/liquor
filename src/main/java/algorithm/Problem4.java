package algorithm;

/**
 * @description:
 * @author: chenbowei
 * @since: 2021/4/24 09:56
 **/
public class Problem4 {
    public static void main(String[] args) {
        Problem4 pro = new Problem4();
        int[] nums1 = new int[]{1, 2, 4};
        int[] nums2 = new int[]{3, 4};
        double mid = pro.findMedianSortedArrays(nums1, nums2);
        assert mid == pro.findMedianSortedArrays2(nums1, nums2);
    }

    /**
     * 归并解法
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 中位数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int cur = 0;
        int[] merge = new int[nums1.length + nums2.length];
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                merge[cur++] = nums1[i++];
            } else if (nums2[j] <= nums1[i]) {
                merge[cur++] = nums2[j++];
            }
        }
        while (i < nums1.length)
            merge[cur++] = nums1[i++];
        while (j < nums2.length)
            merge[cur++] = nums2[j++];

        int totalLength = nums1.length + nums2.length;
        if (totalLength % 2 == 0) {
            return (double) (merge[totalLength / 2] + merge[totalLength / 2 - 1]) / 2;
        } else {
            return merge[totalLength / 2];
        }
    }

    /**
     * log（m+n）解法
     * 思想为将寻找中位数转换为寻找两个数组中第 k 小（大）的元素
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 中位数
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int midIdx = totalLength / 2;

        if (totalLength % 2 == 0)
            // 偶数个
            return (getKthElement(nums1, nums2, midIdx) + getKthElement(nums1, nums2, midIdx + 1)) >> 1;
        else
            //奇数个
            return getKthElement(nums1, nums2, midIdx);
    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length, length2 = nums2.length;
        int idx1 = 0, idx2 = 0;
        while (true) {
            if (idx1 == length1) {
                return nums2[idx2 + k - 1];
            }
            if (idx2 == length2) {
                return nums1[idx1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[idx1], nums2[idx2]);
            }
            int half = k / 2;
            int newIdx1 = Math.min(idx1 + half, length1) - 1;
            int newIdx2 = Math.min(idx2 + half, length2) - 1;
            if (nums1[newIdx1] <= nums2[newIdx2]) {
                k -= (newIdx1 - idx1 + 1);
                idx1 = newIdx1 + 1;
            } else {
                k -= (newIdx2 - idx2 + 1);
                idx2 = newIdx2 + 1;
            }
        }
    }
}
