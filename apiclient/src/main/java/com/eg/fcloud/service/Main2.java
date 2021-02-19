package com.eg.fcloud.service;

import lombok.val;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(" ");
        List<String> list = new LinkedList<>();
        for (int i = 0; i < Integer.valueOf(s[0]); i++) {
            list.add(s[i+1]);
        }

        List<String> res = new ArrayList<>();
        for (String s1 : list) {
            if(null == s1 || "".equals(s1)) continue;
            int start = 0, end = 8;
            int length = s1.length()/8;
            if (s1.length() % 8 > 0){
               ++length;
            }

            for (int i = 0; i < length; i++) {
                end = end > s1.length()? s1.length(): end;
                String current = s1.substring(start, end);
                while (current.length() < 8){
                    current += "0";
                }
                res.add(current);
                start +=8;
                end += 8;
            }
        }
        String[] result  = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        Arrays.sort(result);
        System.out.println(String.join(" ", result));
    }

}
