package sorting;

import java.util.*;

public class Sorting {
	
	//Merge sort
	public static int[] mergeSort(int[] nums) {
		
		int[] helper = new int[nums.length];
		mergeSortHelper(nums, helper, 0, nums.length - 1);
		return nums;
	}
	
	private static void mergeSortHelper(int[] nums, int[] helper, int low, int high) {
		
		if (low == high)
			return;
		int mid = (low + high) / 2;
		mergeSortHelper(nums, helper, low, mid);
		mergeSortHelper(nums, helper, mid+1, high);
		merge(nums, helper, low, mid, high);
	}
	
	private static void merge(int[] nums, int[] helper, int low, int mid, int high) {
		
		//Copy current array into helper array
		for (int i = low; i <= high; i ++) {
			helper[i] = nums[i];
		}
		int left = low;
		int right = mid + 1;
		int current = low;
		
		while (left <= mid && right <= high) {
			if (helper[left] > helper[right]) {
				nums[current] = helper[right];
				right ++;
			}
			else {
				nums[current] = helper[left];
				left ++;
			}
			current ++;
		}
		
		while (left <= mid) {
			nums[current] = helper[left];
			current ++;
			left ++;
		}
	}
	
	
	
	public static void main(String[] args) {
		int[] list = new int[] {4,5,6,1,2,3};
		Sorting.mergeSort(list);
		System.out.println(Arrays.toString(list));
	}

}
