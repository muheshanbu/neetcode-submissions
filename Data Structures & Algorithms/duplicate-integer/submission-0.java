class Solution {
    public boolean hasDuplicate(int[] nums) {
        //HashSet - can immediately exit if duplicate is found, else need to have HashMap and have a key and its count
        HashSet<Integer> list = new HashSet<>();
        for(int i = 0; i< nums.length; i++){
            if(!list.add(nums[i])){
                return true;
            }
        }
        return false;
        
    }
}