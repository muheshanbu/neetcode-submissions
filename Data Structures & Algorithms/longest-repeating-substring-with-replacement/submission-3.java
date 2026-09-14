class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        char[] chars = s.toCharArray();
        Map<Character,Integer> freq = new HashMap<>();
        int maxCount = 0;

        while(left < s.length() && right < s.length()){
            freq.put(chars[right],freq.getOrDefault(chars[right], 0) + 1);

            maxCount = Math.max(maxCount,freq.get(chars[right]));
            
            //Invalid window
            if((right - left + 1) - maxCount > k){
                //remove that exiting count in freq
                freq.put(chars[left],freq.get(chars[left]) - 1);
                left++;
            }

            right++;


        }
        return right - left;
    }
}
