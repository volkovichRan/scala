package com.main.ran.utils
import reflect.runtime.universe._
import scala.reflect.ClassTag

trait ToMap {

  def toMap: Map[String, _] = {
    val mirror = runtimeMirror(this.getClass.getClassLoader)
    val instanceMirror = mirror.reflect(this)
    mirror.classSymbol(this.getClass).toType.members collect {
      case member: MethodSymbol if member.isGetter  =>
        member.name.toString -> instanceMirror.reflectMethod(member).apply()
    } toMap
  }

  def mapTo[T: TypeTag: ClassTag](map: Map[String, _]) = {
    val mirror = runtimeMirror(this.getClass.getClassLoader)
    val constructor = typeOf[T].decl(termNames.CONSTRUCTOR).asMethod
    val classMirror = mirror.reflectClass(typeOf[T].typeSymbol.asClass)
    val constructorMirror = classMirror.reflectConstructor(constructor)

    val constructorArgs = constructor.paramLists.flatten.map( (param: Symbol) => {
      val paramName = param.name.toString
      if(param.typeSignature <:< typeOf[Option[_]])
        map.get(paramName)
      else
        map.getOrElse(paramName, throw new IllegalArgumentException("Map is missing required parameter named " + paramName))
    })

    constructorMirror(constructorArgs:_*).asInstanceOf[T]
  }
}
