class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        HashSet<Character> chars = new HashSet<>();
        int count  = 0;
        int maxCount = 0;
        while(end < s.length()){
            //Trying to add chars to hashset as we see em, if not deal w it
            if(!chars.add(s.charAt(end))){
                maxCount = Math.max(count,maxCount); //saving the max count until this
                end = start + 1; //Moving the start of count to exclude the new found duplicate
                count = 0;
                start = end;
                chars.clear(); //Resetting to clean slate on new counting
            }else{
                count++;
                end++;
            }
        }
        return Math.max(maxCount,count); //in case of positive scenario where count isnt cut of ever
    }
}
