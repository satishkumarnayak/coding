package org.garage.coding.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/*
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3

Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2


 */

public class MajorityElement {

	public static void main(String[] args) {
		MajorityElement demo = new MajorityElement();
		int[] nums = {3, 2, 3};
	//	int[] nums = {2,2,1,1,1,2,2};
		int majorityElement = demo.majorityElement(nums);
		System.out.println(majorityElement);

	}

	public int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap();
		for (int i = 0; i < nums.length; i++) {
				if(map.containsKey(nums[i])) {
					Integer val = map.get(nums[i]);
					val++;
				//	map.put(nums[i], val);
					map.put(nums[i], map.get(nums[i]) + 1);
				} else {
					map.put(nums[i], 1);
				}
		}
		
		Iterator<Integer> iterator = map.keySet().iterator();
		Integer ele = 0;
		while(iterator.hasNext()) {
			Integer key = iterator.next();
			Integer val = map.get(key);
			if(val > nums.length/2) {
				ele = key;
				break;
			}
		}
		return ele;
	}

}
