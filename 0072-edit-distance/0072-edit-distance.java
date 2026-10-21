class Solution {
    public int minDistance(String word1, String word2) {
        return space(word1, word2);
    }

    public int space(String s1, String s2){
        int m = s1.length();
        int n = s2.length();

        int[] dp = new int[n+1];
        for(int j=0;j<=n;j++){
            dp[j] = n - j;
        }

        for(int i=m-1;i>=0;i--){
            int[] curr = new int[n+1];
            curr[n] = m - i;
            for(int j=n-1;j>=0;j--){
                if(s1.charAt(i) == s2.charAt(j)){
                    curr[j] = dp[j+1];
                }
                else{
                    int insert = 1 + curr[j+1];
                    int delete = 1 + dp[j];
                    int replace = 1 + dp[j+1];

                    curr[j] = Math.min(insert, Math.min(delete, replace));
                }
            }
            dp = curr;
        }

        return dp[0];
    }

    public int tabulation(String s1, String s2){
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m+1][n+1];
        for(int j=0;j<=n;j++){
            dp[m][j] = n - j;
        }
        for(int i=0;i<=m;i++){
            dp[i][n] = m - i;
        }

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1];
                }
                else{
                    int insert = 1 + dp[i][j+1];
                    int delete = 1 + dp[i+1][j];
                    int replace = 1 + dp[i+1][j+1];

                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[0][0];
    }

    public int memo(String s1, String s2){
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m][n];
        for(int[] row : dp) Arrays.fill(row, -1);

        return rec(s1, s2, 0, 0, dp);
    }

    public int rec(String s1, String s2, int i, int j, int[][] dp){
        int m = s1.length();
        int n = s2.length();

        if(i == m){
            return n - j;
        }

        if(j == n){
            return m - i;
        }

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            dp[i][j] = rec(s1, s2, i+1, j+1, dp);
        }
        else{
            int insert = 1 + rec(s1, s2, i, j+1, dp);
            int delete = 1 + rec(s1, s2, i+1, j, dp);
            int replace = 1 + rec(s1, s2, i+1, j+1, dp);

            dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }

        return dp[i][j];
    }
}