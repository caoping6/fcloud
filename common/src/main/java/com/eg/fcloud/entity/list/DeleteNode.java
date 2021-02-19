package com.eg.fcloud.entity.list;

import java.util.LinkedList;
import java.util.List;

public class DeleteNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        Solution solution = new Solution();
        ListNode listNode = solution.removeNthFromEnd(head, 1);
        System.out.println(listNode);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    /**
     * leetcode: 19
     * 解决删除头节点的问题  添加一个dummy节点
     * 三个指针分别是前指针  当前指针  末尾指针
     * -1		1	2	3	4	5
     * dumy    slow	fast
     * pre
     *
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode slow = head;
        ListNode fast = head;
        for(int i=0;i<n;i++){
            fast = fast.next;
        }
        while(fast!=null){
            pre = pre.next;
            slow = slow.next;
            fast = fast.next;
        }
        pre.next = slow.next;
        return dummy.next;
    }
}
