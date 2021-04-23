    package algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: chenbowei
 * @since: 2021/4/23 23:15
 * @problem https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 * CASE 1：<br>
 *  * INPUT: abcabcbb
 *  * OUTPUT: 3
 * CASE 2：<br>
 * * INPUT: pwwkew
 * * OUTPUT: 3
 * CASE 3：<br>
 * * INPUT: bbbbbb
 * * OUTPUT: 1
 **/
public class Problem3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcbc"));
    }

    public static int lengthOfLongestSubstring(String s) {
        Set occ = new HashSet<Character>();
        int left = 0, right = 0;
        int ans = 0;

        while (right < s.length()) {
            // 右窗口移动
            while (right < s.length() && !occ.contains(s.charAt(right))) {
                occ.add(s.charAt(right++));
            }
            // 左窗口移动
            occ.remove(s.charAt(left++));

            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

}
