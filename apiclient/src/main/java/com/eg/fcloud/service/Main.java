package com.eg.fcloud.service;

import io.swagger.models.auth.In;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n = 5000;
        int i = 0;
        Scanner sc = new Scanner(System.in);
        List<String> list = new LinkedList<>();

        while (sc.hasNextLine()){
            String date = sc.nextLine();
            list.add(date);
            i++;
            if(i >= n) break;
        }
        
        
        int res = 0;
        Map<String, String> map = new HashMap<>();
        for (String s : list) {
            String[] split = s.split(".");
            String pre = split[0];
            String suf = split[1];

            Integer value = map.get(pre) == null? null
                    : Integer.valueOf(map.get(pre));

            if(value == null){
                map.put(pre, suf);
            } else if(value.intValue() > Integer.valueOf(suf).intValue()){
                map.put(pre, suf);
            }
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            StringBuffer sb = new StringBuffer();
            sb.append(entry.getKey()).append(".").append(entry.getValue());
            for (int j = 0; j < list.size(); j++) {
                if (sb.toString().equals(list.get(i))) {
                    res ++;
                }
            }

        }
        System.out.println(res);
    }
}
