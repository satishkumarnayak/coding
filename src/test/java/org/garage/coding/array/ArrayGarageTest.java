package org.garage.coding.array;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

/*An array organizes items sequentially, one after another in memory.
Each position in the array has an index, starting at 0. */

/*Strengths:
 * 
    Fast lookups. Retrieving the element at a given index takes O(1) time, regardless of the length of the array.
    
    Fast appends. Adding a new element at the end of the array takes O(1)time.
*/

/*Weaknesses:

    Fixed size. You need to specify how many elements you're going to store in your array ahead of time. (Unless you're using a fancy dynamic array.)

    Costly inserts and deletes. You have to "scoot over" the other elements to fill in or close gaps, which takes worst-case O(n)time.
*/

/*Worst Case
space 	O(n)
lookup 	O(1)
append 	O(1)
insert 	O(n)
delete 	O(n)*/
public class ArrayGarageTest {

	@Before
	public void setUp() throws Exception {
	}

	// dataType[] arrayRefVar; // preferred way.
	@Test
	public void testArrayDeclare() {

		int[] a;
		int a1[];

		String[] str;

		int[][] multi;

	}

	/*
	 * Two ways to create array dataType[] arrayRefVar = new dataType[arraySize];
	 * dataType[] arrayRefVar = {value0, value1, ..., valuek};
	 */
	@Test
	public void testArrayCreation() {
		int[] a = new int[3];

		// Defaults to zeros
		assertEquals(0, a[0]); // o(1)
		assertEquals(0, a[1]);
		assertEquals(0, a[2]);

		String[] str = new String[3];
		// Defaults to null
		assertEquals(null, str[0]);
		assertEquals(null, str[1]);
		assertEquals(null, str[2]);

		int[] b = { 12, 12, 13 };
		assertEquals(12, b[0]);
		assertEquals(12, b[1]);
		assertEquals(13, b[2]);

		String[] str2 = { "one", "two", "three" };
		assertEquals("one", str2[0]);
		assertEquals("two", str2[1]);
		assertEquals("three", str2[2]);
	}

	// O(n)
	@Test
	public void testTraverseArray() {

		// Normal loop
		int[] b = { 11, 12, 13 };
		for (int i = 0; i < b.length; i++) {
			// System.out.println(b[i]);
		}

		// For each loop
		String[] str2 = { "one", "two", "three" };
		for (String s : str2) {
			// System.out.println(s);
		}

	}

	/*
	 * Array slicing involves taking a subset from an array and allocating a new
	 * array with those elements.
	 * 
	 * O(n) -> Space and time as looping through the array and assigning it to new
	 * new array is required
	 */
	@Test
	public void testArraySlicing() {
		int[] originalArray = new int[8];
		for (int i = 0; i < originalArray.length; i++) {
			originalArray[i] = i;
		}

		int[] slicedArray = Arrays.copyOfRange(originalArray, 2, 6);
		assertEquals(2, slicedArray[0]);
		assertEquals(3, slicedArray[1]);
		assertEquals(4, slicedArray[2]);
		assertEquals(5, slicedArray[3]);

	}

	/**
	 * An in-place algorithm operates directly on its input and changes it, instead
	 * of creating and returning a new object. This is sometimes called destructive,
	 * since the original input is "destroyed" when it's edited to create the new
	 * output.
	 */
	@Test
	public void inPlaceVsOutOfPlace() {
		int[] inputArray = { 1, 2, 3, 4 };
		int[] outputArray = squareArrayInPlace(inputArray);
		assertEquals(Arrays.toString(inputArray), Arrays.toString(outputArray));

		int[] inputArray2 = { 2, 5, 3, 8 };
		int[] outputArray2 = squareArrayOutOfPlace(inputArray2);
		assertNotEquals(Arrays.toString(inputArray2), Arrays.toString(outputArray2));

	}

	/*
	 * Working in-place is a good way to save space. An in-place algorithm will
	 * generally have O(1) space cost.
	 */
	public int[] squareArrayInPlace(int[] input) {
		for (int i = 0; i < input.length; i++) {
			input[i] = input[i] * input[i];
		}
		return input;
	}

	/*
	 * out-of-place algorithms are considered safer because they avoid side effects.
	 * You should only use an in-place algorithm if you're very space constrained or
	 * you're positive you don't need the original input anymore, even for debugging
	 */
	public int[] squareArrayOutOfPlace(int[] input) {
		int[] output = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			output[i] = input[i] * input[i];
		}
		return output;
	}

	@Test
	public void testDynamicArray() {

		DynamicArray dynamicArray = new DynamicArray();

		dynamicArray.append(1);
		int[] array = dynamicArray.getArray();

		assertEquals("[1, 0, 0, 0, 0]", Arrays.toString(array));

		dynamicArray.append(2);
		dynamicArray.append(3);
		dynamicArray.append(4);
		dynamicArray.append(5);
		array = dynamicArray.getArray();
		assertEquals("[1, 2, 3, 4, 5]", Arrays.toString(array));

		dynamicArray.append(6);
		array = dynamicArray.getArray();
		assertEquals("[1, 2, 3, 4, 5, 6, 0, 0, 0, 0]", Arrays.toString(array));

		dynamicArray.insert(2, 8);
		array = dynamicArray.getArray();
		assertEquals("[1, 2, 8, 3, 4, 5, 6, 0, 0, 0]", Arrays.toString(array));

		dynamicArray.insert(1, 4);
		array = dynamicArray.getArray();
		assertEquals("[1, 4, 2, 8, 3, 4, 5, 6, 0, 0]", Arrays.toString(array));

		dynamicArray.insert(6, 3);
		array = dynamicArray.getArray();
		assertEquals("[1, 4, 2, 8, 3, 4, 3, 5, 6, 0]", Arrays.toString(array));

	}

	@Test
	public void testInsertDynamicArray() {

		DynamicArray dynamicArray = new DynamicArray();

		dynamicArray.append(1);
		dynamicArray.append(2);

		int[] array = dynamicArray.getArray();
		System.out.println(Arrays.toString(array));

		dynamicArray.insert(0, 3);
		int[] array2 = dynamicArray.getArray();

		assertEquals("[3, 1, 2, 0, 0]", Arrays.toString(array));

	}
	
	@Test
	public void testInsertDynamicArray2() {

		DynamicArray dynamicArray = new DynamicArray();

		dynamicArray.append(1);
		dynamicArray.append(2);

		int[] array = dynamicArray.getArray();
		System.out.println(Arrays.toString(array));

		dynamicArray.insert(1, 3);
		int[] array2 = dynamicArray.getArray();

		assertEquals("[1, 3, 2, 0, 0]", Arrays.toString(array));

	}
	
	@Test
	public void testInsertDynamicArray3() {

		DynamicArray dynamicArray = new DynamicArray();

		dynamicArray.append(1);
		dynamicArray.append(2);

		int[] array = dynamicArray.getArray();
		System.out.println(Arrays.toString(array));

		dynamicArray.insert(2, 3);
		int[] array2 = dynamicArray.getArray();

		assertEquals("[1, 2, 3, 0, 0]", Arrays.toString(array));

	}
	
	@Test
	public void testInsertDynamicArray4() {

		DynamicArray dynamicArray = new DynamicArray();

		dynamicArray.append(1);
		dynamicArray.append(2);

		int[] array = dynamicArray.getArray();
		System.out.println(Arrays.toString(array));

		dynamicArray.insert(2, 3);
		int[] array2 = dynamicArray.getArray();

		assertEquals("[1, 2, 3, 0, 0]", Arrays.toString(array));

	}
	
	@Test
	public void testDeleteDynamicArray() {

		DynamicArray dynamicArray = new DynamicArray();

		dynamicArray.append(2);
		int[] array = dynamicArray.getArray();
		System.out.println(Arrays.toString(array));
		dynamicArray.delete(0);
		int[] array2 = dynamicArray.getArray();
		assertEquals("[0, 0, 0, 0, 0]", Arrays.toString(array));

	}
	
	@Test
	public void testDeleteDynamicArray2() {

		DynamicArray dynamicArray = new DynamicArray();

		dynamicArray.append(1);
		dynamicArray.append(2);
		int[] array = dynamicArray.getArray();
		System.out.println(Arrays.toString(array));
		dynamicArray.delete(0);
		int[] array2 = dynamicArray.getArray();
		assertEquals("[2, 0, 0, 0, 0]", Arrays.toString(array2));

	}
	
	@Test
	public void testDeleteDynamicArray3() {

		DynamicArray dynamicArray = new DynamicArray();

		dynamicArray.append(1);
		dynamicArray.append(2);
		dynamicArray.append(3);
		dynamicArray.append(4);

		int[] array = dynamicArray.getArray();
		System.out.println(Arrays.toString(array));
		dynamicArray.delete(2);
		int[] array2 = dynamicArray.getArray();
		assertEquals("[1, 2, 4, 0, 0]", Arrays.toString(array2));

	}
	
	@Test
	public void testDeleteDynamicArray4() {

		DynamicArray dynamicArray = new DynamicArray();

		dynamicArray.append(1);
		dynamicArray.append(2);
		dynamicArray.append(3);
		dynamicArray.append(4);
		dynamicArray.append(5);
		

		int[] array = dynamicArray.getArray();
		System.out.println(Arrays.toString(array));
		dynamicArray.delete(4);
		int[] array2 = dynamicArray.getArray();
		assertEquals("[1, 2, 3, 4, 0]", Arrays.toString(array2));

	}
	
	@Test
	public void testDeleteDynamicArray5() {

		DynamicArray dynamicArray = new DynamicArray();

		dynamicArray.append(1);
		dynamicArray.append(2);
		dynamicArray.append(3);
		dynamicArray.append(4);
		dynamicArray.append(5);
		dynamicArray.append(6);
		

		int[] array = dynamicArray.getArray();
		System.out.println(Arrays.toString(array));
		dynamicArray.delete(4);
		int[] array2 = dynamicArray.getArray();
		assertEquals("[1, 2, 3, 4, 6, 0, 0, 0, 0, 0]", Arrays.toString(array2));

	}
}
