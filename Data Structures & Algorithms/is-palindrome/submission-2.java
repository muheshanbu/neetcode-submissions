class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        //Instead of computing lower case each time, just lower casing the whole string
        s = s.toLowerCase();
        while(start < end){
            //To skip over non-apha numeric from left
            while(start < end && !Character.isLetterOrDigit(s.charAt(start))){
                start ++;
            }
            //To skip over non-apha numeric from RIGHT
            while(start < end && !Character.isLetterOrDigit(s.charAt(end))){
                end--;
            }
            
            if (s.charAt(start) == s.charAt(end)) {
               start++;
               end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
