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
package name.javacode.codinginterview.algorithm.recursion;

import static java.util.Arrays.stream;
import static name.javacode.codinginterview.algorithm.recursion.PracticeQuestionsCh9.magicIndex;
import static name.javacode.codinginterview.algorithm.recursion.PracticeQuestionsCh9.perm;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

/**
 * @author Author
 */
public class PracticeQuestionsCh9Test {

	@Test
	public void testMagicIndex() {
		int[] array = new int[] { -1, 0, 2 };

		assertEquals(2, magicIndex(array, 0, array.length));

		array = new int[] { 1, 2, 3 };

		assertEquals(-1, PracticeQuestionsCh9.magicIndex(array, 0, array.length));
	}

	@Test
	public void testPerm() {
		String s = "abc";

		String[] expected = new String[] { "cab", "abc", "bac", "acb" };

		Set<String> allPerms = perm(s);

		assertEquals(expected.length, allPerms.size());

		stream(expected).forEach(aPerm -> assertTrue(allPerms.contains(aPerm)));
	}
}
