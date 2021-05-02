package algorithm;

/**
 * @description: 盛最多水的容器
 * @author: chenbowei
 * @since: 2021/5/2 19:32
 * https://leetcode-cn.com/problems/container-with-most-water/， 双指针
 * @tag
 **/
public class Solution11 {

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 1};
        Solution11 solution = new Solution11();
        System.out.println(solution.maxArea(input));
    }

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        while (left != right) {
            res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

}
