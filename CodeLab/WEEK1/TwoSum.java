import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map; 
 
 public class TwoSum {

     public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        System.out.println(twoSum(arr, 9));
    }
 
 public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
}

 }