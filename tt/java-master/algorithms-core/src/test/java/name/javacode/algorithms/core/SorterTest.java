package name.javacode.algorithms.core;

/*******************************************************************************
 * Copyright (c) 2014, the original author or authors.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * A copy of the GNU General Public License accompanies this software, 
 * and is also available at http://www.gnu.org/licenses.
 *******************************************************************************/

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Author
 */
public class SorterTest {

	@Test
	public void testMergeSort() {
		int[] arr = new int[] { 17, 3, 99, 51 };
		int[] expected = new int[] { 3, 17, 51, 99 };

		int[] actual = Sorter.mergeSort(arr);

		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testQuickSort() {
		int[] arr = new int[] { 17, 3, 99, 51 };
		int[] expected = new int[] { 3, 17, 51, 99 };

		int[] actual = Sorter.quickSort(arr);

		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testBucketSort() {
		int[] arr = new int[] { 17, 3, 99, 51 };
		int[] expected = new int[] { 3, 17, 51, 99 };

		int[] actual = Sorter.bucketSort(arr);

		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testCountingSort() {
		int[] arr = new int[] { 17, 3, 99, 51 };
		Integer[] expected = { 3, 17, 51, 99 };

		Integer[] actual = Sorter.countingSort(arr);

		Assert.assertArrayEquals(expected, actual);
	}
}
