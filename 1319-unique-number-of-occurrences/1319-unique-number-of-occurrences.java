class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int x : arr) {
            freq.put(x,freq.getOrDefault(x, 0) + 1);
        }
        HashSet<Integer> set = new HashSet<>(freq.values());
        if(freq.size()==set.size()){
            return true;
        }
        return false;
    }
}