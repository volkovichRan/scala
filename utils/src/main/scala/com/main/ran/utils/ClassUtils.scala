package com.main.ran.utils

object ClassUtils {

  class ClassUtils[T <: AnyRef](instance:T){
    def className: String = instance.getClass.getName
  }

  implicit def toClassUtils[T <: AnyRef](instance:T) = new ClassUtils(instance.getClass)
}
