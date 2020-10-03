class Solution {
    public int[] nextGreaterElements(int[] nums) {
                Stack<Integer> greater = new Stack();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        
        boolean secondTime = false;
        int max=Integer.MIN_VALUE;
        for(int i=0; i<2*nums.length; i++){
            
            if ( i > nums.length-1 )
                secondTime = true;
            
            i = i%(nums.length);
            max = Math.max(nums[i], max);
			
            while( !greater.isEmpty() && nums[greater.peek()] < nums[i] ){
                result[greater.pop()] = nums[i];
            }
            
            if( secondTime && max == nums[i] ) break;
            
            greater.push(i);
        }
        return result;
    }
}