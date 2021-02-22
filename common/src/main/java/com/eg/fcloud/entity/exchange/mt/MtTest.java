package com.eg.fcloud.entity.exchange.mt;

/**
 * @Author: CAOPING
 * @Date: 2021/2/7 11:32
 * @Description:
 */
public class MtTest {
    public static void main(String[] args) {
//        LongestDistance inst = new LongestDistance();
//        int dis = inst.getDis(new int[]{5, 10}, 2);
//        System.out.println(dis);

        MaxInnerRec mx  = new MaxInnerRec();
        int i = mx.countArea(new int[]{2, 7, 9, 4, 1}, 5);
        System.out.println(i);
    }
}

class LongestDistance {
    //0≤0≤1<2
    public int getDis(int[] A, int n) {
        // write code here
        if (A == null || A.length < 2) {
            return 0;
        }
        int res = 0;
        int currMin = A[0];
        for (int i = 1; i < A.length; i++) {
            res = Math.max(res, A[i] - currMin);
            currMin = Math.min(currMin, A[i]);
        }
        return res;
    }
}


class MaxInnerRec {
    public int countArea(int[] A, int n) {
        // [281,179,386,165,88,500],6
        if(n == 1) return A[0];
        if(n == 2) return 2 * Math.min(A[0], A[1]);
        int res = 0;
        int l = 0, r = n -1;
        while (l < r){

            if(A[l] < A[r]){
                res = Math.max((r - l + 1)* A[l], res);
                l ++;
            }else {
                res = Math.max((r - l + 1)* A[r], res);
                r --;
            }
        }
        return res;

    }
}

