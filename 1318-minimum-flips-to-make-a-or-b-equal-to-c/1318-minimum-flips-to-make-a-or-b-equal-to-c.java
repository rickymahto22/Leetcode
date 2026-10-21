class Solution {
    public int minFlips(int a, int b, int c) {
      int ans = 0;
        while (c != 0 || a != 0 || b != 0) {
            if (c % 2 == 0) {
                ans += a % 2 + b % 2;
            } else if (a % 2 == 0 && b % 2 == 0) {
                ans++;
            }
            c /= 2;
            a /= 2;
            b /= 2;
        }
        return ans;  
    }
}