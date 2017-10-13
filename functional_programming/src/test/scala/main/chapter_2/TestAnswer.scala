package main.chapter_2

import main.BaseTest
import Answers._

class TestAnswer extends BaseTest {

  "the 10 items of fibonacci" should "be 0, 1, 1, 2, 3, 5, 8, 13, 21, 34" in {
    val acceptedAnswers = List(0, 1, 1, 2, 3, 5, 8, 13, 21, 34)
    val answers = for (i <- 0 to 9) yield
      fibonacci(i)
    acceptedAnswers should contain theSameElementsAs answers
  }

  "order list" should "return true" in {
    val orderList = List(0, 1, 2, 3, 5, 8, 13, 21, 34)
    isSorted(orderList, (a: Int, b: Int) => a < b) should equal(true)
  }


  "unorderd list" should "return false" in {
    val orderList = List(0, 1, 2, 3, 5, 8, 13, 21, 34).reverse
    isSorted(orderList, (a: Int, b: Int) => a < b) should equal(false)
  }

  "curry" should "convert function with multi inputs to single input" in {
    val plus = (a: Int, b: Int) => a + b
    val plusOne = (a: Int) => curry(plus)(a)(1)
    plusOne(2) should equal(3)
  }

  "uncurry" should "convert function with single input to mulit inputs" in {
    val plus = (a: Int, b: Int) => a + b
    unCurry(curry(plus))(1, 2) should equal(3)
  }

  "compose function" should "get 2 function and create 1 function" in {
    val plusOne = (a: Int) => a + 1
    val double = (a: Int) => a * 2
    compose(double, plusOne)(5) should equal(11)
  }


}
