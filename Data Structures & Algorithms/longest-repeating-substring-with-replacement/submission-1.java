class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        char[] chars = s.toCharArray();
        HashMap<Character,Integer> freq = new HashMap<>();

        while(left < s.length() && right < s.length()){
            freq.put(chars[right],freq.getOrDefault(chars[right], 0) + 1);

            Map.Entry<Character,Integer> max = Collections.max(
                freq.entrySet(),Map.Entry.comparingByValue());
            
            //Invalid window
            if((right - left + 1) - max.getValue() > k){
                //remove that exiting count in freq
                freq.put(chars[left],freq.get(chars[left]) - 1);
                left++;
            }

            right++;


        }
        return right - left;
    }
}
