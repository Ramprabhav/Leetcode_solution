class Solution {
    public boolean isPalindrome(int x) {
        int old_num=x;
        int reverse=0;
        if(x<0){
            return false;
        }else{
            while(x>0){
                int r=x%10;
                reverse=reverse*10+r;
                x=x/10;
            }
            if(old_num==reverse){
                return true;
            }else{
                return false;
            }
        }
        
    }
}