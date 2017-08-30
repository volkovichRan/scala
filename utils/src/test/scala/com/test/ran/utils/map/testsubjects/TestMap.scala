package com.test.ran.utils.map.testsubjects

import org.scalatest.{FlatSpec, Matchers}
import com.main.ran.utils.ClassUtils._

class TestMap extends FlatSpec with Matchers {

  SimpleCaseClass.className should "become map of all his attributes name to value" in {
    val testSubject = new SimpleCaseClass(1, 1.1)
    testSubject.toMap should equal(Map("int" -> 1, "double" -> 1.1))
  }

  SimpleClass.className should "become map of all his attributes" in {
    val testSubject = new SimpleClass(1, 1.1)
    testSubject.toMap should equal(Map("int" -> 1, "double" -> 1.1))
  }

  ComplexClass.className should "become map of all his attributes name to value including the extended class" in {
    val testSubject = new ComplexClass(7, 1, 1.1)
    testSubject.toMap should equal(Map(
                                       "long" -> 7,
                                       "int" -> 1,
                                       "double" -> 1.1))
  }
}
