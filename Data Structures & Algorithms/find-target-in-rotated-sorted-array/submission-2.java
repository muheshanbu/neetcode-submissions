class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < nums[right]){
                //right half is sorted now for sure
                if(nums[mid] < target && target <= nums[right]){
                    //means target is in the right sorted area
                    left = mid + 1;
                }else{
                    //target is in the unsorted left area
                    right = mid - 1;
                }

            }else if(nums[mid] > nums[right]){
                //now left half is sorted now for sure
                if(nums[left] <= target && target < nums[mid]){
                    //checking if target is in sorted area
                    right = mid - 1;
                }else{
                    //target should be in unsorted area
                    left = mid + 1;
                }
            }
        }
        return nums[left] == target ? left : -1; 
        //blegh, edge case where left and right merges but answer isnt in search space
    }
}

// 5 6 1 2 3 4

// 6 1 2 3 4 5

// 1 2 3 4 5 6


// 4 5 6 1 2 3

// 3 4 5 6 1 2

// 2 3 4 5 6 1