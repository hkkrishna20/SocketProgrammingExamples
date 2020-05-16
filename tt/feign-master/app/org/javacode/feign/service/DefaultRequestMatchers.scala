package org.javacode.feign.service

import org.javacode.feign.api.matcher.RequestMatchers
import org.javacode.feign.matcher._

/**
  * @author Abhijit Sarkar
  */
class DefaultRequestMatchers extends RequestMatchers {
  override val getMatchers = Seq(new DefaultPathMatcher, new DefaultMethodMatcher, new DefaultQueriesMatcher,
    new DefaultHeadersMatcher, new DefaultBodyMatcher)
}
