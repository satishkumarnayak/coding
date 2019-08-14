package org.garage.coding.pramp;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) {
	//	 int[] arr = {3};
		// int limit = 5;
	//	int[] arr = { 4, 6, 10, 15, 16 };
		
		int[] arr = {4,4,1};
		int limit = 5;
	;

		int[] indicesOfItemWeights = getIndicesOfItemWeights(arr, limit);
		System.out.println(Arrays.toString(indicesOfItemWeights));
	}

	static int[] getIndicesOfItemWeights(int[] arr, int limit) {
		int[] emptyResult = {};
		
		if(arr.length == 1) {
			return emptyResult;
		}
		int[] result = new int[2];
		Map<Integer, Integer> arrMap = new HashMap();

		for (int i = 0; i < arr.length; i++) {
			arrMap.put(i, arr[i]);
		}
		System.out.println(arrMap);
		for (int i = arr.length - 1; i >= 0; i--) {
			int targetValue = limit - arr[i];
			if (arrMap.containsValue(targetValue)) {
				result[0] = getIndex(arr, targetValue);
				result[1] = i;
			} 
		}
		return result;
	}

	static int[] getIndicesOfItemWeights3(int[] arr, int limit) {
		int[] result = new int[2];
		Map<Integer, Integer> arrMap = new HashMap();
		/*
		 * for (int i = 0; i < arr.length; i++) { arrMap.put(i, arr[i]); }
		 */ System.out.println(arrMap);
		for (int i = arr.length - 1; i >= 0; i--) {
			int targetValue = limit - arr[i];
			if (arrMap.containsValue(targetValue)) {
				result[0] = getIndex(arr, targetValue);
				result[1] = i;
			} else {
				arrMap.put(i, arr[i]);
			}
		}
		return result;
	}

	static int[] getIndicesOfItemWeights2(int[] arr, int limit) {
		int[] result = new int[2];

		for (int i = arr.length - 1; i >= 0; i--) {
			int targetValue = limit - arr[i];
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == targetValue) {
					result[0] = j;
					result[1] = i;
				}
			}
		}
		return result;
	}

	static int[] getIndicesOfItemWeights1(int[] arr, int limit) {
		int[] result = new int[2];
		Map<Integer, Integer> arrMap = new HashMap();
		for (int i = 0; i < arr.length; i++) {
			arrMap.put(i, arr[i]);
		}
		System.out.println(arrMap);
		for (int i = arr.length - 1; i >= 0; i--) {
			int targetValue = limit - arr[i];
			if (arrMap.containsValue(targetValue)) {
				Stream<Integer> s = arrMap.entrySet().stream().filter(E -> E.getValue().equals(targetValue))
						.map(Map.Entry::getKey);
				Integer keyIndex = s.collect(Collectors.toList()).get(0);
				result[0] = keyIndex;
				result[1] = i;
			}
		}
		return result;
	}

	private static int getIndex(int[] arr, int targetValue) {
		int result = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == targetValue) {
				result = i;
			}
		}
		return result;
	}

}