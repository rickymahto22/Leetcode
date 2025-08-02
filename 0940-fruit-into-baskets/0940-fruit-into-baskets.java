class Solution {
    public int totalFruit(int[] fruits) {
        int l = 0, r = 0,ans = 0;
        Map<Integer, Integer> count = new HashMap<>();
        while(r<fruits.length){
            count.put(fruits[r], count.getOrDefault(fruits[r], 0) + 1);
            if(count.size() > 2) {
                count.put(fruits[l], count.get(fruits[l]) - 1);
                if (count.get(fruits[l]) == 0) {
                    count.remove(fruits[l], 0);
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}