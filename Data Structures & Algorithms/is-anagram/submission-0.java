class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        char [] sChar = s.toCharArray();
        char [] tChar = t.toCharArray();
        HashMap<Character,Integer> sMap = new HashMap<>();
        HashMap<Character,Integer> tMap = new HashMap<>();
        for(Character c : sChar){
            sMap.put(c,sMap.getOrDefault(c, 0)+1);
        }
        for(Character c: tChar){
            tMap.put(c,tMap.getOrDefault(c, 0)+1);
        }
        return sMap.equals(tMap);
    }
}
