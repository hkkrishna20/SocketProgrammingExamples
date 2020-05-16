/*
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
 */

package name.abhijitsarkar.coffeehouse.cdi;

import name.abhijitsarkar.coffeehouse.cdi.event.CDICloseCoffeeShopTest;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestSuiteRunner;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Abhijit Sarkar
 */
@RunWith(CdiTestSuiteRunner.class)
@Suite.SuiteClasses({
        CDIBaristaTest.class,
        CDICloseCoffeeShopTest.class
})
public class CDITestSuite {
}
