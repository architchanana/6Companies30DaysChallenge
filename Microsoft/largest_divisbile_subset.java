package com.company.arsh_goyal.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class largest_divisbile_subset {
    public static void main(String[] args) {

    }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int []dp=new int[nums.length];
        int []hash=new int[nums.length];
        for(int i=0;i<hash.length;i++){
            hash[i]=i;
        }
        Arrays.fill(dp,1);
        for(int index=0;index<nums.length;index++){
            for(int prev=0;prev<=index-1;prev++){
                if(nums[index]%nums[prev]==0){
                    int t=dp[index];
                    dp[index]=Math.max(1+dp[prev],dp[index]);
                    if(dp[index]!=t){
                        hash[index]=prev;
                    }
                }
            }
        }
        int t=0;
        int index=0;
        for(int i=0;i<dp.length;i++){
            if(t<dp[i]){
                t=dp[i];
                index=i;
            }
        }
        ArrayList<Integer>s=new ArrayList<>();
        while(t>0){
            s.add(nums[index]);
            index=hash[index];
            t--;
        }
        Collections.reverse(s);
        return s;
    }
}
