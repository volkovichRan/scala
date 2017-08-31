package com.test.ran.utils.map

import com.test.ran.utils.BasicTest
import com.test.ran.utils.map.testsubjects.{ComplexClass, SimpleCaseClass, SimpleClass}

class TestMapTo extends BasicTest {

  "Map with key as attribute name and value" should "become simple class" in {
    val map = Map("int" -> 1, "double" -> 1.1)
    SimpleClass.mapTo[SimpleClass](map).toString should equal(new SimpleClass(1, 1.1).toString)
  }

  ignore should "become simple case class" in {
    val map = Map("int" -> 1, "double" -> 1.1)
    SimpleCaseClass.mapTo[SimpleCaseClass](map) should equal(new SimpleClass(1, 1.1))
  }

  it should "become complex class " in {
    val map = Map("long" -> 7, "int" -> 1, "double" -> 1.1)
    ComplexClass.mapTo[ComplexClass](map).toString should equal(new ComplexClass(7, 1, 1.1).toString)
  }

}
