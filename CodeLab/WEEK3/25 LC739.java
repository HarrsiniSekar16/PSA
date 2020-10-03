class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> st = new Stack<>();
        st.push(T.length-1);
        res[T.length-1] = 0;
        for (int i = T.length-2; i >= 0; i--) {
            while (!st.isEmpty() && T[st.peek()] <= T[i]) st.pop();
            res[i] = st.isEmpty() ? 0 : st.peek()-i;
            st.push(i);
        }
        return res;
    }
}
