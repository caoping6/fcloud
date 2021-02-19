package com.eg.fcloud.entity.exchange;

import lombok.val;

import java.util.*;

public class Dym {
    public static void main(String[] args) {
//        SolutionD solutionD = new SolutionD();
//        int[] a = new int[]{4,2,1};
//        int i = solutionD.minCount(a);
//        System.out.println(i);
//        SolutionL l = new SolutionL();
//        String s = l.longestPalindrome("babad");
//        System.out.println(s);
        SolutionM m = new SolutionM();
        String s = "()";
        boolean valid = m.isValid(s);
        System.out.println(valid);

    }
}


class SolutionD {
    public int minCount(int[] coins) {
        //f(x) = min{f(x-1) + 1, f(x-2) + 1}
        int res = 0;
        for(int coin: coins){
            int sum = coin%2 == 0 ? coin/2 : (coin+1)/2 ;
            res +=sum;
        }
        return res;
    }

    public int singleCount(int num, Map<Integer,Integer> map){
        // 1 || 2
        int[] dp = new int[num + 1];
        dp[0] = 0;

        if(map.containsKey(num)){
            return map.get(num);
        }
        //f[1],f[2],f[3]....f[n]
        int i,j;
        for( i = 1; i <= num; i++){
            dp[i] = Integer.MAX_VALUE;
            //last count
            //dp[i] =  min(dp[i-1] + 1, dp[i-2]+1)
            if( i >= 1 && dp[i-1] <Integer.MAX_VALUE){
                dp[i] = Math.min(dp[i], dp[i-1] + 1);
            }

            if(i >= 2 && dp[i-2] <Integer.MAX_VALUE){
                dp[i] = Math.min(dp[i], dp[i-2] + 1);
            }
            map.put(i,dp[i]);
        }

        return dp[num];
    }
}

class SolutionL {
    //最长回文数
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2){
            return s;
        }
        char[] ss = s.toCharArray();
        boolean[][] dp = new boolean[len][len];

        dp[0][0] = true;
        int begin = 0;
        int res = 0;
        for(int i =0 ; i < len ; i++){
            int ll = 0;
            for(int j=i;j<len;j++){
                if (i == 0 && j == 0){
                    dp[i][j] = true;
                }
                else if(i ==0 && j == 1 && ss[i] == ss[j]){
                    dp[i][j] = true;
                    res = 2;
                }
                else if(i < j && ss[i] == ss[j]){
                    dp[i][j] = dp[i + 1][j -1];
                    if(dp[i][j]){
                        if(j-i + 1 > res){
                            res = j -i + 1;
                            begin = i;
                        }
                    }
                } else{
                    dp[i][j] = false;
                }
            }
        }
        return s.substring(begin,begin + res -1);
    }
}


/**
 * 有效的括号
 */
class SolutionM {
//    private static final Map<Character,Character> map = new HashMap<Character,Character>(){{
//        put('{','}'); put('[',']'); put('(',')'); put('?','?');
//    }};
    private  static final Map<Character, Character> map = new HashMap<Character, Character>(){{
        put('{','}'); put('[',']'); put('(',')'); put('?','?');
    }};
    public boolean isValid(String s) {
        if (s.length() % 2 != 0){return false;}
        LinkedList<Character> list = new LinkedList();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                list.add(c);
            } else if (list.size() == 0 || map.get(list.removeLast()) != c) {
                return false;
            }
        }
        return list.size() == 0;
    }
}
