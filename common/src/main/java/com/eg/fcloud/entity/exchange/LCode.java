package com.eg.fcloud.entity.exchange;

import jdk.nashorn.internal.ir.IfNode;

import java.net.SocketTimeoutException;
import java.util.*;

/**
 * @Author: CAOPING
 * @Date: 2021/2/1 17:43
 * @Description:  nums = [2,7,11,15], target = 9
 */
public class LCode {
    public static void main(String[] args) {
//        ListNode l1 = new ListNode(8);
//        l1.next = new ListNode(9);
//        l1.next.next = new ListNode(9);
//
//        ListNode l2 = new ListNode(8);
//        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(9);
//        l2.next.next.next = new ListNode(9);
//        l2.next.next.next.next = new ListNode(9);
//
//        Solution2 solution2 = new Solution2();
//        ListNode listNode = solution2.addTwoNumbers(l1, l2);
//        System.out.println(listNode);

        Solution3 solution3 = new Solution3();
        int size = solution3.lengthOfLongestSubstring("abcabcdadefjkl");
        System.out.println(size);
    }


}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            return null;
        }
        Map<Integer, Integer> map  = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //243
        //564
        //708
        ListNode result = new ListNode(0);
        ListNode tmp  = result;
        int move = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int a = x + y + move;
            int b = a % 10;
            move = a / 10;

            tmp.next = new ListNode(b);
            tmp = tmp.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (move == 1) {
            tmp.next = new ListNode(move);
        }
        return result.next;
    }
}

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        //abc abcd adefjkl
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                start = Math.max(start, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - start + 1);
        }
        return res;
    }
}

class Solution4 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int start  = 0;
        int left = 0;
        int len = Integer.MAX_VALUE;
        int valid = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid ++;
                }
            }

            while (valid == need.size()){
                if (i - left < len) {
                    start = left;
                    len = i - left;
                }
                char c1 = s.charAt(left);
                left ++;
                if (need.containsKey(c1)) {
                    if (window.get(c1).equals(need.get(c1))) {
                        valid--;
                    }
                    window.put(c1, window.getOrDefault(c1, 0) -1);
                }
            }

        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}