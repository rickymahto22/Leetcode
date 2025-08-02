class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return func(nums, k) - func(nums, k - 1);
    }
    private int func(int[] nums, int k) {
        int l = 0, r = 0,cnt = 0;
        Map<Integer, Integer> count = new HashMap<>();
        while(r<nums.length){
            count.put(nums[r], count.getOrDefault(nums[r], 0) + 1);
            while(count.size() > k) {
                count.put(nums[l], count.get(nums[l]) - 1);
                if (count.get(nums[l]) == 0) {
                    count.remove(nums[l], 0);
                }
                l++;
            }
            cnt+=r - l + 1;
            r++;
        }
        return cnt;
    }
}