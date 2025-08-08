class Solution {
    public String reverseVowels(String s) {
        char[] chars=s.toCharArray();
        String vowels="AEIOUaeiou";
        int st=0,end=chars.length-1;
        while(st<end){
            while(st<end && vowels.indexOf(chars[st])==-1){
                st++;
            }
            while(st<end && vowels.indexOf(chars[end])==-1){
                end--;
            }
            char ch=chars[st];
            chars[st]=chars[end];
            chars[end]=ch;
            st++;
            end--;
        } 
        return new String(chars);
    }
}