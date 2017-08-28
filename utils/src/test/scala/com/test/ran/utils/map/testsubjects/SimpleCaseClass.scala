package com.test.ran.utils.map.testsubjects

import com.main.ran.utils.ToMap

case class SimpleCaseClass(int: Int, double: Double) extends ToMap

trait SimpleClass extends ToMap {
  val int: Int
  val double: Double
}

class ComplexClass(long: Long, override val int: Int, override val double: Double) extends SimpleClass




