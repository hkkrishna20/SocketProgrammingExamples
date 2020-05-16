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
package name.javacode.programminginterviews.arraysnstrings;

import static name.javacode.programminginterviews.arraysnstrings.PracticeQuestionsCh6.keypadPermutation;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class PracticeQuestionsCh6Test {
	@Test
	public void testKeypadPermutation() {
		List<String> expected = new ArrayList<>();
		expected.add("AD");
		expected.add("AE");
		expected.add("AF");
		expected.add("BD");
		expected.add("BE");
		expected.add("BF");
		expected.add("CD");
		expected.add("CE");
		expected.add("CF");

		Assert.assertEquals(expected, keypadPermutation(23));
		
		expected.clear();
		expected.add("A");
		expected.add("B");
		expected.add("C");
		
		Assert.assertEquals(expected, keypadPermutation(12));
	}
}
