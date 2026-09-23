class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] < nums[right]){
                //answer should be in other side, since this sided is sorted ascending
                right = mid; // But this side has mid, which dould be a potential min candidate
            }else if(nums[mid] > nums[right]){
                //sus - disturbance in the force, leave right as is and move left pointer
                left = mid + 1;
            }
        }
        return nums[left];    //the pointers converge and that final is the min
    }
}
