class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0, r = 0, zeroes = 0, maxlen = 0;
        while(r<nums.length){
            if(nums[r] == 0 ) zeroes++;
            if(zeroes>k){
                if(nums[l]==0) zeroes--;
                l++;
            }
            if(zeroes<=k){
                maxlen= r-l + 1;
                maxlen=Math.max(maxlen,maxlen);
            }
            r++;
        }
        return maxlen;
    }
}