package com.test.ran.utils.map.testsubjects

import com.main.ran.utils.ToMap

object SimpleCaseClass extends BasicClass

case class SimpleCaseClass(int: Int, double: Double) extends BasicClass

object SimpleClass extends BasicClass

class SimpleClass(val int: Int, val double: Double) extends BasicClass

trait BasicClass extends ToMap {
  override def toString: String = toMap.toString
}

object ComplexClass extends BasicClass

class ComplexClass(val long: Long, override val int: Int, override val double: Double) extends SimpleClass(int, double)




