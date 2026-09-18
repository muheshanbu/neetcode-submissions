class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();
        for(String s: tokens){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int b = Integer.parseInt(stack.pop()); //returns a primitve int
                int a = Integer.parseInt(stack.pop());
                switch (s) {
                    case "+" ->
                        stack.push(String.valueOf(a+b));
                    case "-" ->
                        stack.push(String.valueOf(a-b));
                    case "*" -> 
                        stack.push(String.valueOf(a*b));
                    case "/" ->
                        stack.push(String.valueOf(a/b)); //convert the operated value back to string
                }
            }else{
                stack.push(s);
            }
        }
        return Integer.parseInt(stack.peekFirst());
    }
}
