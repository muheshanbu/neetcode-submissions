class Solution {
   public boolean isPalindrome(String s) {
        char[] charArr = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while(start < end){

            while(start < end && !Character.isLetterOrDigit(charArr[start])){
                start ++;
            }

            while(start < end && !Character.isLetterOrDigit(charArr[end])){
                end--;
            }

                if (Character.toLowerCase(charArr[start]) == Character.toLowerCase(charArr[end])) {
                    start++;
                    end--;
                } else {
                    return false;
                }
            }

        return true;
    }
}
