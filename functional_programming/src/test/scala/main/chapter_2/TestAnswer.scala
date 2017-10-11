package main.chapter_2

import main.BaseTest

class TestAnswer[A] extends BaseTest {

  "the 10 items of fibonacci" should "be 0, 1, 1, 2, 3, 5, 8, 13, 21, 34" in {
    val acceptedAnswers = List(0, 1, 1, 2, 3, 5, 8, 13, 21, 34)
    val answers = for (i <- 0 to 9) yield
      Answers.fibonacci(i)
    acceptedAnswers should contain theSameElementsAs (answers)
  }

  "order list" should "return true" in {
    val orderList = List(0, 1, 2, 3, 5, 8, 13, 21, 34)
    Answers.isSorted(orderList, (a: Int, b: Int) => a < b) should equal(true)
  }


  "unorderd list" should "return false" in {
    val orderList = List(0, 1, 2, 3, 5, 8, 13, 21, 34).reverse
    Answers.isSorted(orderList, (a: Int, b: Int) => a < b) should equal(false)
  }


}
