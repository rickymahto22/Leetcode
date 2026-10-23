class Solution {
    static int ishourPossible(int []piles,int k){
        int totalhour=0;
        for(int i=0;i<piles.length;i++){
            totalhour+=Math.ceil((double)piles[i]/k);
        }
        return totalhour;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int ans=0,st=1,end=(int)1e9;
        while(st<=end){
            int mid=st+(end-st)/2;
            int totalhour=ishourPossible(piles,mid);
            if(totalhour<=h){
                ans=mid;
                end=mid-1;
            }
            else{
                st=mid+1;
            }
        }
        return ans;
    }
}