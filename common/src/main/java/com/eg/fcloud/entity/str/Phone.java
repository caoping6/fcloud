package com.eg.fcloud.entity.str;


import java.util.*;

public class Phone {
    public static void main(String[] args) {
        int index = "23".charAt(1) - (1+'0');
        System.out.println(index);
        Solution solution = new Solution();
        List<String> strings = solution.letterCombinations("23");
        System.out.println(strings.toString());
    }
}

class Solution  extends LinkedHashMap {

    private String letterMap[] = {
            " ",    //0Lin
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    private List<String> res = new LinkedList<>();



    //广度优先
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return res;
        }
        Double len = Math.pow(3, digits.length());
        ArrayDeque<String> que = new ArrayDeque(len.intValue());

        que.push("");
        for(int i = 0; i < digits.length(); i++){
            //遍历que 拼接当前字符
            int index = digits.charAt(i) - '0';
            String s = letterMap[index];
            char[] arrs = s.toCharArray();
            int size = que.size();
            for(int j = 0; j < size; j ++ ){
                String pop = que.pop();
                for (char arr : arrs) {
                    que.push(pop + arr);
                }
            }
        }
        if (que.size() > 1){
            String[] resArrs = que.toArray(new String[len.intValue()]);
            res = Arrays.asList(resArrs);
        }
        return res;
    }


    //深度优先  电话号码组合 leetcode:17
    public List<String> letterCombinations2(String digits) {
        if(digits.length() == 0){
            return res;
        }
        findCom(digits, 0, "");
        return res;
    }

    private void findCom(String digits, int idx, String s){
        if(idx == digits.length()){
            res.add(s);
            return;
        }
        Character a = digits.charAt(idx);
        int aa = Integer.valueOf(a + "");
        String letter = letterMap[aa];
        for(int i = 0; i < letter.length(); i ++ ){
            findCom(digits,idx + 1, s + letter.charAt(i));
        }
    }
}
