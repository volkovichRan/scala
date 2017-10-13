package main.chapter_3


sealed trait MyList[+E]{
  def size[E]: Int
}

case object Nil extends MyList[Nothing] {
  override def size[E] = 0
}

case class Cons[+E](e: E, tail: MyList[E]) extends MyList[E]{
  override def size[E] = {
    this match {
      case Cons(_, Nil) => 1
      case Cons(_, _) => 1 + tail.size
    }
  }
}

object MyList {

  def apply[E](elements: E*): MyList[E] = {
    elements.size match {
      case 0 => Nil
      case _ => new Cons(elements.head, apply(elements.tail:_*))
    }
  }

}
