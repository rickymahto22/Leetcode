class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int val:arr){
            int rem=val%k;
            if(rem<0){
                rem+=k;
            }
            int of=map.getOrDefault(rem,0);
            map.put(rem,of+1);
        }
        for(int val:arr){
            int rem=val%k;
            if(rem<0){
                rem+=k;
            }
            if(rem==0){
                int fq=map.get(rem);
                if(fq%2==1){
                   return false; 
                }
            }else if(2*rem==k){
                int fq=map.get(rem);
                if(fq%2==1){
                   return false; 
                }
            }else{
                int fq=map.get(rem);
                int ofq=map.getOrDefault(k-rem,0);
                if(fq!=ofq){
                   return false; 
                }
            }
        }
        return true;
    }
}