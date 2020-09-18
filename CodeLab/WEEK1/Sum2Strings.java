import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map; 

public class Sum2Strings {

    public static void main(String[] args) {
        System.out.println(sumTwoStrings("523", "32"));
    }

    // Assuming both of them are non negative
    private static String sumTwoStrings(String str1, String str2){
        int len1 = num1.length();
        int len2 = num2.length();
        int idx1 = len1 - 1;
        int idx2 = len2 - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(idx1 >= 0 || idx2 >= 0){
            int x = idx1 >= 0 ? num1.charAt(idx1) - 48 : 0; // or ... num1.charAt(idx1) - '0' : 0; 
            int y = idx2 >= 0 ? num2.charAt(idx2) - 48 : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            sb.append(sum % 10);
            
            idx1--;
            idx2--;
        }
        
        if(carry > 0)
            sb.append('1');
        
        return sb.reverse().toString();

    }


}