import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map; 

class RotateArray {

public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        System.out.println(rotate(arr, 2));
    }

  public void rotate(int[] nums, int k) {
    k = k % nums.length;
    int count = 0;
    for (int start = 0; count < nums.length; start++) {
      int current = start;
      int prev = nums[start];
      do {
        int next = (current + k) % nums.length;
        int temp = nums[next];
        nums[next] = prev;
        prev = temp;
        current = next;
        count++;
      } while (start != current);
    }
  }
}