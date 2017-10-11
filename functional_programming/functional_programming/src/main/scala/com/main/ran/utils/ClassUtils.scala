package com.main.ran.utils

object ClassUtils {

  class ClassUtils[TYPE](instance: TYPE) {
    def className: String = instance.getClass.getName

    def constructFromMapToT[T](map: Map[String, _])(implicit evidence: T <:< ToMap): T = {
      ???
    }
  }

  implicit def toClassUtils[TYPE](instance: TYPE) = new ClassUtils(instance.getClass)
}
