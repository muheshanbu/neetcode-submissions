class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        //Since sorted array and O(logn) time, proceeding w binary search
        while(left <= right){
            int mid = (left + right) / 2;  //or maybe if the ip was wider, left + (right-left)/2
            if(nums[mid] == target) {
                return mid;
            }
            else if(target > nums[mid]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
}
