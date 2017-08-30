package com.main.ran.utils

object ClassUtils {

  class ClassUtils[TYPE](instance:TYPE){
    def className: String = instance.getClass.getName
  }

  implicit def toClassUtils[TYPE](instance:TYPE) = new ClassUtils(instance.getClass)
}
