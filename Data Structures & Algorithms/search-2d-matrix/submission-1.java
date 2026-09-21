class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //First to narrow down which row it could be
        //so running binary search on all row's first col
        int l1 = 0;
        int r1 = matrix.length - 1;

        while(l1 <= r1){
            int midRow = (l1 + r1)/2; //so if 3 ros, 1st is mid and 4 rows, 2nd is mid

            //target row is found, initiate binary search into this, another while loop
            if(matrix[midRow][0] <= target && matrix[midRow][matrix[midRow].length - 1] >= target){ 
                int left = 0; int right = matrix[midRow].length - 1;

                while(left <= right){
                    int midCol = (left + right)/2;
                    if(matrix[midRow][midCol] == target){
                        return true;
                    }else if(matrix[midRow][midCol] > target){
                        right = midCol - 1;
                    }else{
                        left = midCol + 1;
                    }
                }
                return false;

            }else if(matrix[midRow][0] < target){
                l1 = midRow + 1;
            }else{
                r1 = midRow - 1;
            }
        }
        return false;
    }
    
}

