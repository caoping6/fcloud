package com.eg.fcloud.entity.str;

import java.util.LinkedList;

public class KuoHao {
    public static void main(String[] args) {
        String str = "(()";
        SolutionK sk = new SolutionK();
        sk.longestValidParentheses(str);
    }


}

class SolutionK {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        LinkedList<Integer> stack = new LinkedList();
        stack.add(-1);
        int res = 0;
        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) == '('){
                stack.add(i);
            } else {
                stack.removeLast();
                if(stack.size() == 0){
                    stack.add(i);
                } else {
                    res = Math.max(res, i - stack.getLast());
                }
            }
        }
        return res;
    }
}