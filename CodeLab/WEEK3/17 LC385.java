
class Solution {
public NestedInteger deserialize(String s) {
        if (s == null) {
            return null;
        }
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }
        char[] arr = s.toCharArray();
        int n = arr.length;
        
        Stack<NestedInteger> stack = new Stack<>();
        int i = 0;
        while (i < n) {
            if (arr[i] == '[') {
                stack.push(new NestedInteger());
            } else if (Character.isDigit(arr[i]) || arr[i] == '-') {
                int num = 0;
                int sign = 1;
                if (arr[i] == '-') {
                    sign = -1;
                    i++;
                }
                while (i < n && Character.isDigit(arr[i])) {
                    num = num * 10 + arr[i] - '0';
                    i++;
                }
                i--;
                stack.peek().getList().add(new NestedInteger(num * sign));      
            } else if (arr[i] == ']') {
                NestedInteger ni = stack.pop();
                if (!stack.isEmpty()) {
                    stack.peek().getList().add(ni);
                } else {
                    return ni;
                }
            }
            i++;
        }
        
        return stack.pop();
    }
}