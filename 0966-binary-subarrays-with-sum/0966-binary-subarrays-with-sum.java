class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return func(nums, goal) - func(nums, goal - 1);
    }
    private int func(int[] nums, int goal) {
        if(goal<0) return 0;
        int l=0, r = 0, sum = 0, cnt = 0;
        for (r = 0; r < nums.length; r++){
            sum += nums[r];
            while (sum > goal ) {
                sum -= nums[l];
                l++;
            }
            cnt += r-l + 1;
        }
        return cnt;
    }
}