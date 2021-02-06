package com.eg.fcloud.entity.str;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Phone {
    public static void main(String[] args) {
        System.out.println('a');
        System.out.println('A');
        System.out.println(Integer.valueOf('A'));
        System.out.println(Integer.valueOf('a'));
        System.out.println(Integer.valueOf('0'));
        System.out.println(Integer.valueOf('2'));
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

    private ArrayList<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
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
