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
package name.javacode.codinginterview.datastructure.stacksnqueues;

import name.javacode.algorithms.core.datastructure.Stack;

/**
 * @author Author
 */
/*
 * Q3.2: How would you design a stack which, in addition to push and pop, also has a function min which returns the
 * minimum element? Push, pop and min should all operate in O(1) time.
 */

public class StackWithMin<E extends Comparable<E>> extends Stack<E> {
	private E min = null;

	@Override
	public E push(E element) {
		if (stack.add(0, element)) {
			adjustMin(element);

			return element;
		}

		return null;
	}

	@Override
	public E pop() {
		E element = stack.remove(0);

		adjustMin(element);

		return element;
	}

	/*
	 * This implementation of min is buggy. It works the 1st time, but once a minimum element is popped, it loses track
	 * of the new minimum which could be anywhere in the stack. c.f. Programming interviews Q8.1 for a working solution.
	 */
	private final void adjustMin(E element) {
		if (min == null) {
			min = element;
		} else if (min.compareTo(element) > 0) {
			min = element;
		}
	}

	public E min() {
		return this.min;
	}
}
