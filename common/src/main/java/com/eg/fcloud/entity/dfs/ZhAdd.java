package com.eg.fcloud.entity.dfs;

import java.util.LinkedList;
import java.util.List;

public class ZhAdd {
    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] ca = new int[]{2,3,6,7};
        List<List<Integer>> lists = sl.combinationSum(ca, 7);
        System.out.println(lists.toString());
    }
}

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList();
        if(candidates.length == 0) return res;
        LinkedList<Integer> path = new LinkedList();
        dfs(candidates, 0 ,target, path, res);
        return res;
    }

    public void dfs(int[] candidates, int begin, int target, LinkedList<Integer> path, List<List<Integer>> res){
        if(target<0){
            return;
        }
        if(target==0){
            res.add(path);
            return;
        }

        for(int i=begin; i<candidates.length;i++){
            path.add(candidates[i]);
            dfs(candidates, i, target - candidates[i], path, res);
            path.removeLast();
        }
    }
}
