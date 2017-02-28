package com.example.java.algorithm;

import java.util.Arrays;

public class MergeSort {
	
	static int[] doSort(int[] array) {
		if (array.length == 1) {
			return array;
		}
		
		final int middle = array.length / 2 - 1;
		
		int[] left = Arrays.copyOfRange(array, 0, middle + 1);
		left = doSort(left);
		
		int[] right= Arrays.copyOfRange(array, middle + 1, array.length);
		right = doSort(right);
		
		return merge(left, right);
	}

	static int[] merge(int[] left, int[] right) {
		int[] ret = new int[left.length + right.length];
		int leftCursor = 0;
		int rightCursor = 0;
		int i = 0;

		while (leftCursor < left.length && rightCursor < right.length) {
			if (left[leftCursor] <= right[rightCursor]) {
				ret[i] = left[leftCursor];
				++leftCursor;
			} else {
				ret[i] = right[rightCursor];
				++rightCursor;
			}
			++i;
		}

		while (leftCursor < left.length) {
			ret[i] = left[leftCursor];
			++leftCursor;
			++i;
		}

		while (rightCursor < right.length) {
			ret[i] = right[rightCursor];
			++rightCursor;
			++i;
		}

		return ret;
	}

}
