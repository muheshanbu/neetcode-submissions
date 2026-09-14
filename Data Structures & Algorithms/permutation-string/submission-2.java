class Solution {
     public boolean checkInclusion(String s1, String s2) {
        int[] s1freq = new int[26];
        int[] s2freq = new int[26];

        if(s1.length() > s2.length()) return false;

        //New technique i learnt to track freq instead of a hashmap, given char is a fixed case alphabet
        for(int i = 0; i < s1.length(); i++){
            char c = s1.charAt(i);
            s1freq[c - 'a']++;
            char d = s2.charAt(i);
            s2freq[d - 'a']++;
        }
        if(Arrays.equals(s1freq,s2freq)) return true;

        int left = 0;
        int right = s1.length() - 1;

        while(right < s2.length() - 1){
        
            s2freq[s2.charAt(left) - 'a']--; //removing left in freq
            left++; //moving the left pointer

            right++; //expanding window
            s2freq[s2.charAt(right) - 'a']++; //putting it into the freq

            if(Arrays.equals(s1freq,s2freq)) return true;

        }

        return false;


    }
}
