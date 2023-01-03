package com.company.arsh_goyal.week1;

public class rotate_function {
    public static void main(String[] args) {
        int[] arr = {100};
        System.out.println(maxRotateFunction(arr));
    }

    public static int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int first = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            first += i * nums[i];
        }
        int ans = first;
        for (int i = n - 1; i >= 0; i--) {
            first += sum - nums[i] * n;
            ans = Math.max(ans, first);
        }
        return ans;
    }
}
