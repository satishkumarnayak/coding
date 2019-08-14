package org.garage.coding.array;

public class ArrayGarage {

}

class DynamicArray {
	private int[] array;
	private final int CAPACITY = 5;
	private int size = 0;

	public DynamicArray() {
		array = new int[CAPACITY];
	}

	public int[] getArray() {
		return this.array;
	}

	private void resize() {
		int[] newArray = new int[array.length * 2]; // newArray with double the current array size
		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		this.array = newArray;

	}

	public void append(int element) {
		if (size == array.length) {
			resize();
		}
		array[size] = element;
		size++;
	}

	public void insert(int index, int element) {
		// valid index in range
		if (index > size) {
			return;
		}

		if (index == size) {
			append(element);
			return;
		}

		// make space for new element
		for (int i = size; i > index; i--) {
			array[i] = array[i - 1];
		}

		// insert the element
		array[index] = element;
		// size increment
		size++;

	}

	public void delete(int index) {
		if (index > size) {
			return;
		}
		// array[index] = 0;
		// [1, 2, 3, 4, 5] index 4

		if (index == size - 1) {
			array[size - 1] = 0;
			return;
		}

		for (int i = index; i < size; i++) {
			array[i] = array[i + 1];
		}
		size--;

	}
	
	
	
	

}
