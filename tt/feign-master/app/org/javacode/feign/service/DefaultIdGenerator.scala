package org.javacode.feign.service

import org.javacode.feign.api.model.Request
import org.javacode.feign.api.persistence.IdGenerator

/**
  * @author Abhijit Sarkar
  */
final class DefaultIdGenerator extends IdGenerator {
  val pattern = """^(?:/?)([^/]+)(?:.*)$""".r

  override def id(request: Request): String = {
    val prefix = pattern.findFirstMatchIn(request.path)
      .map(_ group 1)
      .getOrElse("unknown")

    s"${prefix}-${request.path.hashCode}"
  }
}
