package com.company.arsh_goyal.week1;

public class shortest_unsorte_array {
    public static void main(String[] args) {

    }
    public int findUnsortedSubarray(int[] nums) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int n=nums.length;
        if(n==1){
            return 0;
        }
        for(int i=0;i<n;i++){
            if(i==0){
                if(nums[i]>nums[i+1]){
                    min=Math.min(nums[i],min);
                    max=Math.max(nums[i],max);
                }
            }
            else if(i==nums.length-1){
                if(nums[i]<nums[i-1]){
                    min=Math.min(nums[i],min);
                    max=Math.max(nums[i],max);
                }
            }
            else{
                if(nums[i]>nums[i+1] || nums[i]<nums[i-1]){
                    min=Math.min(nums[i],min);
                    max=Math.max(nums[i],max);
                }
            }
        }
        //try to find the position of min and max elements
        ///find the position and the substract pos of min - pos of max;
        if(min== Integer.MAX_VALUE && max==Integer.MIN_VALUE){
            return 0;
        }
        int i=0,j=0;
        for(i=0;i<n && nums[i]<=min;i++);
        for(j=n-1;j>=0 && nums[j]>=max;j--);
        return j-i+1;
    }
}
