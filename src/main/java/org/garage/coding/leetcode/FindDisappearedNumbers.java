package org.garage.coding.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author Satish_Nayak Given an array of integers where 1 ≤ a[i] ≤ n (n = size
 *         of array), some elements appear twice and others appear once.
 * 
 *         Find all the elements of [1, n] inclusive that do not appear in this
 *         array.
 * 
 *         Could you do it without extra space and in O(n) runtime? You may
 *         assume the returned list does not count as extra space.
 * 
 *         Example:
 * 
 *         Input: [4,3,2,7,8,2,3,1]
 * 
 *         Output: [5,6]
 *
 * 
 */
public class FindDisappearedNumbers {

	public static void main(String[] args) {
		FindDisappearedNumbers demoDisappearedNumbers = new FindDisappearedNumbers();
	//	int[] input = {4, 3, 2, 7, 8, 2, 3, 1};
		int[] input = {5,4,6,7,9,3,10,9,5,6};
		List<Integer> result = demoDisappearedNumbers
				.findDisappearedNumbers(input);
		System.out.println(result);

	}
	// 1 2 2 3 3 4 7 8
	// 3 4 5 5 6 6 7  9 9 10
	public List<Integer> findDisappearedNumbers(int[] nums) {
		Arrays.sort(nums);
		List<Integer> result = new ArrayList();

		for (int i = 0; i < nums.length; i++) {
			boolean isPresent = Arrays.binarySearch(nums, i+1) >= 0 ? true : false;
			if (nums[i] != i + 1 && !isPresent) {
				result.add(i + 1);
			}
		}
		return result;
	}

}
