class Solution {
    public void dfs(int node, int[][] isConnected, boolean[] isVis) {
        isVis[node] = true;

        for(int i=0; i<isConnected.length; i++){
            if(!isVis[i] && isConnected[node][i] == 1) {
                dfs(i, isConnected, isVis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
       int n = isConnected.length;
        boolean[] isVis = new boolean[n];
        int noOfProvinces = 0;
        for(int i=0; i<n; i++) {
            if(!isVis[i]) {
                dfs(i, isConnected, isVis);
                noOfProvinces++;
            }
        }

        return noOfProvinces; 
    }
}