class Solution {
   public int[] productExceptSelf(int[] nums) {
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            int prod = 1;
            for(int j = 0 ; j < nums.length ; j++){
                if(j != i) {
                    prod = prod * nums[j];
                }
            }
            answer.add(prod);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}  
