package com.test.ran.utils.map.testsubjects

import com.main.ran.utils.ToMap

case class SimpleCaseClass(int: Int, double: Double) extends BasicClass

object SimpleClass extends BasicClass

class SimpleClass(val int: Int, val double: Double) extends BasicClass

trait BasicClass extends ToMap

object ComplexClass extends BasicClass

class ComplexClass(val long: Long, override val int: Int, override val double: Double) extends SimpleClass(int, double)




