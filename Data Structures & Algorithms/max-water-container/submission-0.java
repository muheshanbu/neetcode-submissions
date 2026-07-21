class Solution {
    public int maxArea(int[] heights) {
        //So basically max area is height vs width, so larger the width larger the area, so we start out
        //at the edges, and the maximum height that we can gather is preferred, so move the height bar from either start or end
        int maxArea = 0;
        int start = 0;
        int end = heights.length -1;
        while (start < end) {
            int area = Math.min(heights[start],heights[end]) * (end-start);
            if(area > maxArea) maxArea = area;
            if(heights[start] < heights[end]){
                start++;
            }else if(heights[end]  <= heights[start]){
                end--;
            }
        }
        return maxArea;
    }
}
