package graph;

import java.util.*;

public class Permutation {
	
	//Given a set of distinct numbers
	//Return all possible permutations
	public List<List<Integer>> getAllPermutations(int[] nums) {
		return new ArrayList<List<Integer>>();
	}
	
	public static void main(String[] args) {
		String a = "1234a";
		System.out.println(a.charAt(0) - '0');
		double result = 0;
		for (int i = 0; i < a.length(); i ++) {
			int singleDigit = a.charAt(i) - '0';
			if (singleDigit > 10)
				continue;
			result = result * 10 + singleDigit;
			System.out.println(i + "th iteration: " + result);
		}
	}

}
