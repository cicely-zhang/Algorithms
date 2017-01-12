package linear;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class MaxSubArray {
	public static int maxSubArray(int[] nums) {
        
        int length = nums.length;
        if (length == 0)
            return 0;
        
        int[] max = new int[length];
        return maxSubArrayHelper(nums, max, 0);
    }
    
    private static int maxSubArrayHelper(int[] nums, int[] max, int curIndex) {
        
        if (curIndex == (max.length -1) ) {
            max[curIndex] = nums[curIndex];
            return max[curIndex];
        }
        else if (curIndex < (max.length -1)) {
            int maxSoFar = maxSubArrayHelper(nums, max, curIndex + 1);
            max[curIndex] = Math.max(nums[curIndex], nums[curIndex] + max[curIndex + 1]);
            return Math.max(max[curIndex], maxSoFar);
        }
        return 0;
            
    }
    
    public static void main(String[] args) {
    	try {
    		ArrayList<Integer> integerList = new ArrayList<Integer>();
    		for (String line : Files.readAllLines(Paths.get("C:\\Users\\cicely.zhang\\Desktop\\numbers.txt"))) {
    			for (String part : line.split(",")) {
    				Integer i = Integer.valueOf(part);
    				integerList.add(i);
    			}
        	}
    		int[] ret = new int[integerList.size()];
    	    for (int i=0; i < ret.length; i++)
    	    {
    	        ret[i] = integerList.get(i).intValue();
    	    }
    	    
    		System.out.println(MaxSubArray.maxSubArray(ret));
    	} catch (Exception ex) {
    		System.out.println(ex.getStackTrace());
    	}
    	
    	
	}
}
