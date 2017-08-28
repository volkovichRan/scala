package com.main.ran.utils


trait ToMap {

  def toMap: Map[String, Any] = {
    this.getClass.getDeclaredFields.map {
      f =>
        f.setAccessible(true)
        f.getName -> f.get(this)
    } toMap
  }

}
