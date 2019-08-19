package org.garage.coding.leetcode;

import java.util.Arrays;

/**
 * 
 * Given a non-empty array of integers, every element appears twice except for
 * one. Find that single one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * 
 * Example 1:
 * 
 * Input: [2,2,1] Output: 1
 * 
 * Example 2:
 * 
 * Input: [4,1,2,1,2] Output: 4
 *
 * 
 * 
 */

public class SingleNumber {

	public static void main(String[] args) {
		SingleNumber demo = new SingleNumber();
		int[] nums = {4,1,2,1,2};
		int singleNumber = demo.singleNumber(nums);
		System.out.println(singleNumber);

	}

	// 2 2 1
	// 2 1 1
	// 1 2 2

	// 5
	// 1 1 4
	// 2 2 1

	/*
	 * public int singleNumber(int[] nums) { // Arrays.sort(nums); int found =
	 * -1; int len = nums.length - 1; for (int i = 0; i < nums.length / 2; i++,
	 * len--) { found = nums[len / 2]; if (nums[i] != nums[len]) { found =
	 * nums[len]; } }
	 * 
	 * return found; }
	 */
	 public int singleNumber(int[] nums) {
	        int output = nums[0];
	        for(int i = 1; i < nums.length; i++) {
//	            output ^= nums[i];
	            output = output ^ nums[i];
	        }
	        return output;
	    }

}
