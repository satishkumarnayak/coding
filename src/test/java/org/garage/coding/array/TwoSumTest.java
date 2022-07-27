package org.garage.coding.array;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class TwoSumTest {

	TwoSum twoSum;

	@Before
	public void setUp() {
		twoSum = new TwoSum();
	}

	@Test
	public void solutionTest() {

		int[] nums = { 2, 7, 11, 15 };
		int target = 18;
		int[] result = twoSum.solution(nums, target);
		System.out.println(Arrays.toString(result));
	}

}
