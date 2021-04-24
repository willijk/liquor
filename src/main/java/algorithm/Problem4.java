package algorithm;

/**
 * @description:
 * @author: chenbowei
 * @since: 2021/4/24 09:56
 **/
public class Problem4 {
    public static void main(String[] args) {
        Problem4 pro = new Problem4();
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        double mid = pro.findMedianSortedArrays(nums1, nums2);
        System.out.println(mid);
    }

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
}
