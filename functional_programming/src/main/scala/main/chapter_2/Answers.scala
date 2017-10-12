package main.chapter_2

object Answers {

  def fibonacci(n: Int): Int = {
    def loop(tmp: Int): Int = {
      tmp match {
        case 0 | 1 => tmp
        case n => loop(n - 2) + loop(n - 1)
      }
    }

    loop(n)
  }

  def isSorted[A](l: List[A], order: (A, A) => Boolean): Boolean = {
    l match {
      case Nil => true
      case _ :: Nil => true
      case a :: b => order(a, b.head) && isSorted(b, order)
    }
  }

  def curry[A, B, C](f: (A, B) => C): A => B => C = {
    a => b => f(a, b)
  }

  def unCurry[A, B, C](f: A => B => C): (A, B) => C = {
    (a, b) => f(a)(b)
  }

  def compose[A, B, C](f: A => B, g: B => C): A => C = {
    a => g(f(a))
  }

}
