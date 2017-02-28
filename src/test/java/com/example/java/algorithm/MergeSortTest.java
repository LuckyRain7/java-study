package com.example.java.algorithm;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest {

	@Test
	public void testMerge_1_1() {
		final int[] expecteds = { 1, 2 };
		int[] left = { 1 };
		int[] right = { 2 };
		int[] actuals = MergeSort.merge(left, right);
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testMerge_1_2() {
		final int[] expecteds = { 1, 2 };
		int[] left = { 2 };
		int[] right = { 1 };
		int[] actuals = MergeSort.merge(left, right);
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testMerge_2_1() {
		final int[] expecteds = { 1, 2, 3 };
		int[] left = { 1, 2 };
		int[] right = { 3 };
		int[] actuals = MergeSort.merge(left, right);
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testMerge_2_2() {
		final int[] expecteds = { 1, 3, 2 };
		int[] left = { 3, 2 };
		int[] right = { 1 };
		int[] actuals = MergeSort.merge(left, right);
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testDoSort_1() {
		final int[] expecteds = { 1 };
		int[] samples = { 1 };
		int[] actuals = MergeSort.doSort(samples);
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testDoSort_2() {
		final int[] expecteds = { 1, 2 };
		int[] samples = { 2, 1 };
		int[] actuals = MergeSort.doSort(samples);
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testDoSort_3() {
		final int[] expecteds = { 1, 2, 3 };
		int[] samples = { 3, 2, 1 };
		int[] actuals = MergeSort.doSort(samples);
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testDoSort_4() {
		final int[] expecteds = { 1, 2, 2 };
		int[] samples = { 2, 2, 1 };
		int[] actuals = MergeSort.doSort(samples);
		Assert.assertArrayEquals(expecteds, actuals);
	}

}
