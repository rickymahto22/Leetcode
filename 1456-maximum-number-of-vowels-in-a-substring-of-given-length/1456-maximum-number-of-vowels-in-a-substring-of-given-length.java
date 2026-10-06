class Solution {
    public int maxVowels(String s, int k) {
        int mx = 0, cnt = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                char p = s.charAt(i - k);
                if (p == 'a' || p == 'e' || p == 'i' || p == 'o' || p == 'u') cnt--;
            }
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') cnt++;
            mx = Math.max(mx, cnt);
        }
        return mx;
    }
}