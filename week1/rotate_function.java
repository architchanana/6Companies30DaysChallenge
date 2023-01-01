package com.company.arsh_goyal.week1;

public class rotate_function {
    public static void main(String[] args) {
        int[]arr={100};
        System.out.println(maxRotateFunction(arr));
    }
    public static int maxRotateFunction(int[] nums) {
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            int k=0;
            for(int j=i;j<nums.length+i;j++){
                sum+=(k*nums[j%nums.length]);
                k++;
            }
            maxi=Math.max(maxi,sum);
        }
        return maxi;
    }
}
