package linear;

import java.util.Arrays;
import java.util.HashSet;

public class Atoi {
	
	public int myAtoi(String str) {
        if (str.length() == 0) 
            return 0;
            
        String str_trimed = str.trim();
        boolean isNegative = false;
        int startIndex = 0;
        if (str_trimed.charAt(0) == '-') {
            isNegative = true;
            startIndex ++;
        }
        else if (str_trimed.charAt(0) == '+')
            startIndex ++;
            
        double result = 0;
        for (int i = startIndex; i < str_trimed.length(); i ++) {
            int num = str_trimed.charAt(i) - '0';
            if (num >= 10 || num < 0)
                break;
            result = result * 10 + num;
        }
        
        if (isNegative == true) {
        	result = -result;
        }
        	
        
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        	
        return (int) result;
    }
	
	public static void main(String[] args) {
		Atoi myAtoi = new Atoi();
		System.out.println(myAtoi.myAtoi("2147483648"));
		
		HashSet<Integer> list = new HashSet<Integer>();
		list.addAll(Arrays.asList((new Integer[] {1,2,3,4,2})));
		
		
		System.out.println(list);
	}
}
