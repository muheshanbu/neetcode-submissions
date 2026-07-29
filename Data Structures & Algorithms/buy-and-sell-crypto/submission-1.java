class Solution {
    public int maxProfit(int[] prices) {
        //so sell price is lowest, maybe iterate through the list
        //get lowest

        int min = prices[0];
        int diff = 0;

        for(int i = 0; i < prices.length; i++){
            min = Math.min(min,prices[i]); //so min is picked,
            
            //current i is consider against the min(buy) price and the max difference is to be selected??

            int currentDiff = prices[i] - min;
            diff = Math.max(diff,currentDiff);
        }

        if(diff > 0)
            return diff;
        else
            return 0;
    }
}
