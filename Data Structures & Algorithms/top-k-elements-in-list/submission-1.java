class Solution {
   public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        for (int num : nums) {
            //So my thinking is num is key, the value would be the freq
            //get (Num) gives existing freq, to which i add 1
            freq.put(num, (freq.getOrDefault(num, 0) + 1));
        }

        //Seems for here its a top K problem
        // I can either use a map heap and select get top n values, but its slower and heavier
        //Or Use a Min Heap
            //1 . Keep adding nums to a Min Heap
            //2. As soon as size of heap is bigger than N, remove the smallest num(it has highest priority)
            //3. return resulting queue

        //In this queue im gonna store the numbers themselves, but the order or comparision is based on the map freq
        // (num1,num2)-> freq.get(num1) - freq.get(num2) === Comparator.comparingInt(freq::get)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(freq::get));
        for(int i : freq.keySet()){
            minHeap.add(i);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        //Converting the minHeap to an Array
        return minHeap.stream().mapToInt(Integer::intValue) //Maps the wrapper Integer to the primitive int
                .toArray();
        
        //If order is an issue, create a primitive int array and poll to maintain order
    }
}
