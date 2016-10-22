package graph;

import java.util.*;

public class PowerSet {
	
	public static List<List<Integer>> getPowerSet(int[] nums) {
		List<List<Integer>> retList = new ArrayList<List<Integer>>();
        if (nums == null)
            return retList;
        
        retList.add(new ArrayList<Integer>());
        if (nums.length == 0) {
            return retList;
        }
            
        List<Integer> subset = new ArrayList<Integer>();
        helper(nums, retList, subset, 0);
        return retList;
	}
	
    private static void helper(int[] nums, List<List<Integer>> retList, List<Integer> subset, int current) {
        
        for (int i = current; i < nums.length; i ++) {
            subset.add(nums[i]);
            retList.add(new ArrayList<Integer>(subset));
            helper(nums, retList, subset, i+1);
            subset.remove((Integer) nums[i]);
        }
    }
    
    public static void main(String[] args) {
    	
    	System.out.println(PowerSet.getPowerSet(new int[] {1,2,3}));
    }
}
