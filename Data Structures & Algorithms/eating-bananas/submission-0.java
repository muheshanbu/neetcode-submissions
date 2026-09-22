class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxElement = 0;
        for(int i = 0; i < piles.length; i++){
            if(maxElement < piles[i])
                maxElement = piles[i];
        }
        
        int l = 1; 
        int r = maxElement;
        int currentMin = maxElement;

        while(l <= r){
            int midRate = (l + r) / 2;
            int hours = 0;
            for(int i: piles){
                //Calculating the hours taken if koko eats in this banana's/h(bph)
                hours+=Math.ceil((double)i/midRate);
            }
            //this is a valid rate which is under k hours
            if(hours <= h){
                if(currentMin > midRate)
                    currentMin = midRate;
            //Search for things lesser than this again, so potential bph lesser than k are not skipped
            //narrowing the range to lower rates
                r = midRate - 1;
            }else if (hours > h){
                //need to fasten rate, so moving to higher values
                l = midRate + 1;
            }
        }

        return currentMin;
    }
}
