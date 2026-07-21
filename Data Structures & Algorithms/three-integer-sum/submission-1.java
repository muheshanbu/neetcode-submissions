class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();

        //My understanding is to just use an outer loop, mimic two sum by getting one layer in and using
        //two pointers for the next step
        Arrays.sort(nums);
        for(int i = 0; i< nums.length; i++){
            //The check for duplicates, added after reference ONLY :(
            if(i > 0 && nums[i-1] == nums[i]) continue;

            int start = i + 1;         //cuz the start itself covers all the nums
            int end = nums.length - 1;

            while(start < end){
                int sum = nums[start] + nums[end] + nums[i];
                if(sum > 0){
                    end--;
                }else if(sum < 0){
                    start++;
                }else {
                    answer.add(Arrays.asList(nums[i],nums[start],nums[end]));
                    while(start < end && nums[start] == nums[start+1]) start++;     //Skipping the duplicate
                    while(start < end && nums[end-1] == nums[end]) end--;

                    //To get other valid pairs for this particular outer element
                    start++;
                    end--;
                }
            }
        }
        return answer;
    }
}
