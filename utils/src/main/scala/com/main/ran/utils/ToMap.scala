package com.main.ran.utils
import reflect.runtime.universe._

trait ToMap {

  def toMap: Map[String, Any] = {
    val mirror = runtimeMirror(this.getClass.getClassLoader)
    val instanceMirror = mirror.reflect(this)
    mirror.classSymbol(this.getClass).toType.members collect {
      case member: MethodSymbol if member.isGetter  =>
        member.name.toString -> instanceMirror.reflectMethod(member).apply()
    } toMap
  }

}
