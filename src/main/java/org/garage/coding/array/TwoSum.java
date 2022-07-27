package org.garage.coding.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Satish_Nayak https://leetcode.com/problems/two-sum/
 * 
 *         Given an array of integers nums and an integer target, return indices
 *         of the two numbers such that they add up to target.
 * 
 *         You may assume that each input would have exactly one solution, and
 *         you may not use the same element twice.
 * 
 *         You can return the answer in any order.
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: nums = [2,7,11,15], target = 9 Output: [0,1] Explanation:
 *         Because nums[0] + nums[1] == 9, we return [0, 1]. Example 2:
 * 
 *         Input: nums = [3,2,4], target = 6 Output: [1,2] Example 3:
 * 
 *         Input: nums = [3,3], target = 6 Output: [0,1]
 *
 */
public class TwoSum {

	public int[] solution(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length - 1; i++) {
			map.put(nums[i], i);
		}
		for (int j = 0; j < nums.length - 1; j++) {
			int numToFind = target - nums[j];
			if (map.containsKey(numToFind)) {
				result[0] = map.get(numToFind);
				result[1] = j;
			}
		}
		return result;
	}

}