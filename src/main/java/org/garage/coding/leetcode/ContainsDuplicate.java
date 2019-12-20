package org.garage.coding.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Satish_Nayak Given an array of integers, find if the array contains
 *         any duplicates.
 * 
 *         Your function should return true if any value appears at least twice
 *         in the array, and it should return false if every element is
 *         distinct.
 * 
 *         Example 1:
 * 
 *         Input: [1,2,3,1] Output: true
 * 
 *         Example 2:
 * 
 *         Input: [1,2,3,4] Output: false
 * 
 *         Example 3:
 * 
 *         Input: [1,1,1,3,3,4,3,2,4,2] Output: true
 *
 * 
 * 
 */

public class ContainsDuplicate {

	public static void main(String[] args) {
		ContainsDuplicate code = new ContainsDuplicate();
		int[] nums = { 1,1,1,3,3,4,3,2,4,2 };
		boolean result = code.containsDuplicate(nums);
		System.out.println(result);

	}

	public boolean containsDuplicate(int[] nums) {
		Set<Integer> setnum = new HashSet<Integer>();
		for (int num : nums) {
			if (setnum.add(num) == false)
				return true;
		}
		return false;

	}

}
