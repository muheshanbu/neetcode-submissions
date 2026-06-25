class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> sol = new HashMap<>();
        for(String str: strs){
            char[] charStr = str.toCharArray();
            Arrays.sort(charStr);
            
            String sortedStr = new String(charStr);

            sol.putIfAbsent(sortedStr,new ArrayList<>()); //If no key, add a new empty List
            
            if(sol.containsKey(sortedStr)){
                sol.get(sortedStr).add(str); //sol.get(sortedStr) is exists should return the List<String>, so i can use .add() method here 
            }

        }
        return new ArrayList<>(sol.values()); //sol.values is a List<string>
    }
}
