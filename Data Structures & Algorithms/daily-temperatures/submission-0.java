class Solution {
      public int[] dailyTemperatures(int[] temperatures) {
        int[] results = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < temperatures.length; i++){
            //compare values of incoming potentially hotter day and that peeked element and finally pop it off 
            //if conditions match
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                results[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);   //push the current value into the stack for further analysis
        }
        return results;
    }
}
