class Solution {
   public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> twoSumMap = new HashMap<>();
        for(int i = 0; i< nums.length ; i++){
            //Checking if it already exists in map
            if(twoSumMap.containsKey(nums[i])){
                return new int []{twoSumMap.getOrDefault(nums[i],0),i};

            }
            //Adding if it isn't
            twoSumMap.put((target-nums[i]),i);
            //Seems containsValue is VERY SLOW. So added my lookup stuff as KEY
        }
        return new int[]{};     //just creating and returning an empty array
    }
}
