class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            //What do I separate the strings with??
            //Seems non-ascii characters or some combination of some sort
            sb.append(str.length()).append("#").append(str);
            //Number first - since number second would mean comp doesn't know if its length or actual string only
            //Delimiter second - cuz without it, 11abcd... and 6abcd... would cause ambiguity..like whether is it string or length?
            //String at last, no issues
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        List<String> result = new ArrayList<>();
        while(i < str.length()){
            int j = i; //a temp pointer to keep the number
            while(str.charAt(j) != '#'){
                j++;
            }
            int strPartLength = Integer.parseInt(str.substring(i,j)); //Length of the string is extracted

            //Word is calculated to be from the next char from # to that added to partLength
            String word = str.substring(j+1,j+1+strPartLength);
            result.add(word);
            i = j +1 + strPartLength;
        }
        return result;
    }
}

