package test.chapter_3

import main.chapter_3.{Nil, MyList => List}
import test.BaseTest

class TestAnswers extends BaseTest {

  val list = List(1, 2, 3)
  val list2 = Nil

  "MyList apply" should "get 3 parameters and create MyList with the 3 parameters" in {
    List.size(list) should equal(3)
    List.size(list2) should equal(0)
  }

  "MyList tail" should "remove the first element in the list" in {
    List.size(List.tail(list)) should equal(2)
    List.size(List.tail(list2)) should equal(0)
  }

  "MyList set head" should "have same list with head changed expect when Nil then list should have 1 item" in {
    val t = List.setHead(list, 5)
    val q = List.setHead(list2, 5)
    println(t)
  }

}
