package org.garage.coding.leetcode;

import java.util.Arrays;

/**
 * 
 * @author Satish_Nayak Given an array nums, write a function to move all 0's to
 *         the end of it while maintaining the relative order of the non-zero
 *         elements.
 * 
 *         Example:
 * 
 *         Input: [0,1,0,3,12] Output: [1,3,12,0,0]
 * 
 *         Note:
 * 
 *         You must do this in-place without making a copy of the array.
 *         Minimize the total number of operations.
 *
 * 
 */
public class MoveZeroes {

	public static void main(String[] args) {
		MoveZeroes demo = new MoveZeroes();
		int[] nums = {0, 1, 0, 3, 12};
		demo.moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}
	
//	0 1 0 3 12    
//0	1 0 0 3 12  
//1	1 0 0 3 12


	public void moveZeroes(int[] nums) {
		// Arrays.sort(nums);
		// int j = nums.length - 1;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == 0 && nums[i + 1] != 0 ) {
				int temp = nums[i + 1];
				nums[i + 1] = nums[i];
				nums[i] = temp;

			}
		}

	}

}
