class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int count = 0;
        int maxCount = 0;
        HashSet<Character> chars = new HashSet<>();
        while(right < s.length()){
            //Trying to add chars to hashset as we see em, if not deal w it
            if(!chars.add(s.charAt(right))){
                maxCount = maxCount > count ? maxCount : count;
                count = count - 1;
                chars.remove(s.charAt(left)); //removing only the issued element in the hashset
                left++; //Moving the start of count to exclude the new found duplicate
            }else{
                right++;
                count++;
            }
        }
        return maxCount > count ? maxCount : count; //in case of positive scenario where count isnt cut of ever
    }
}
