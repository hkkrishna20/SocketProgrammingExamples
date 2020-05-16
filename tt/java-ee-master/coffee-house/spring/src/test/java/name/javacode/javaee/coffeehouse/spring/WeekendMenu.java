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

package name.abhijitsarkar.javaee.coffeehouse.spring;

import name.abhijitsarkar.coffeehouse.Menu;
import name.abhijitsarkar.javaee.coffeehouse.spring.annotation.ConditionalOnDayOfTheWeek;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

import javax.inject.Named;

import static name.abhijitsarkar.javaee.coffeehouse.spring.annotation.ConditionalOnDayOfTheWeek.DayOfTheWeek;

/**
 * @author Abhijit Sarkar
 */

@Named
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@ConditionalOnDayOfTheWeek(DayOfTheWeek.WEEKEND)
public class WeekendMenu extends Menu {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeekendMenu.class);

    public WeekendMenu() {
        super();

        LOGGER.debug("Creating a weekend menu.");
    }
}
