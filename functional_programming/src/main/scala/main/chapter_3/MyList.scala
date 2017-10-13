package main.chapter_3

sealed trait MyList[+E]

case object Nil extends MyList[Nothing]

case class Cons[+E](e: E, tail: MyList[E]) extends MyList[E]


object MyList {

  def apply[E](elements: E*): MyList[E] = {
    elements.size match {
      case 0 => Nil
      case _ => new Cons(elements.head, apply(elements.tail: _*))
    }
  }

  def size[_](l: MyList[_]): Int = {
    l match {
      case Nil => 0
      case Cons(_, Nil) => 1
      case Cons(_, tail) => 1 + size(tail)
    }
  }

  def tail[_](l: MyList[_]): MyList[_] = {
    l match {
      case Nil | Cons(_, Nil) => Nil
      case Cons(_, tail) => tail
    }
  }

  def setHead[E](l: MyList[E], e: E): MyList[E] = {
    l match {
      case Nil => Cons(e, Nil)
      case Cons(h, tail) => Cons(e, tail)
    }
  }

  //TODO implement it
  def drop = ???

  //TODO implement it
  def dropWhile = ???

  //TODO from list of 1,2,3,4 to 1,2,3 drop last item
  def init =???

}
