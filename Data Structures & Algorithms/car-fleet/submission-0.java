class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int fleets = 0;
        Deque<Double> stack = new ArrayDeque<>();
        //Since if i directly sort on positions, i'd loose speed
        //creating a 2D array for each car
        int[][] cars = new int[position.length][2];
        for(int i = 0 ; i< position.length; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        //Sort the cars combined int array on the positions(aka starting length)
        Arrays.sort(cars,Comparator.comparingInt(a -> a[0]));
        
        //so to access higher position starting cars i loop in the reverse order, since higher starting cars are the  bottleneck, so anything that follows w a lesser time is absorbed and greater time just creates a new fleet
        for(int i = position.length - 1; i >=0; i--){
            double time = (double) (target - cars[i][0]) / cars[i][1];
           
            if(!stack.isEmpty() && time > stack.peek()) {
                stack.push(time);
            }else if(stack.isEmpty()){
                stack.push(time);
            }
        }
        return stack.size();

    }
}
