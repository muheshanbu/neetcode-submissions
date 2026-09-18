class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String s: tokens){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int b = stack.pop(); 
                int a = stack.pop();
                switch (s) {
                    case "+" ->
                        stack.push(a+b);
                    case "-" ->
                        stack.push(a-b);
                    case "*" -> 
                        stack.push(a*b);
                    case "/" ->
                        stack.push(a/b);
                }
            }else{
                stack.push(Integer.parseInt(s));
                //convert to primitive int and store in stack
            }
        }
        return stack.peekFirst();
    }
}
