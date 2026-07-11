class Solution {
   public int longestConsecutive(int[] nums) {
        HashSet<Integer> uniq = new HashSet<Integer>();

        //Adding the nums array to a hashset for lookups
        for(int i: nums){
            uniq.add(i);
        }

        int maxhigh = 0;

        //Interogatting the hashset
        for(Integer i : uniq){
            //So this is the start
            if(!uniq.contains(i-1)){
                int currentHigh = 1;
                while(uniq.contains(i+currentHigh)){
                    currentHigh++;
                }
                if(currentHigh > maxhigh) {
                    maxhigh = currentHigh;
                }
            }
        }

        //Because the "bouncer" if block ensures that your inner loop only ever visits a number a single time across the entire lifespan of the program,
        // the math is $O(N + N)$, which simplifies to $O(N)$.
        // It does not multiply to $O(N^2)$.
        
        return maxhigh;
    }
}
