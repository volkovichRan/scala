package main.chapter_3

import main.BaseTest

class TestAnswers extends BaseTest {

  "MyList apply" should "get 3 parameters and create MyList with the 3 parameters" in {
    val list = MyList(1, 2, 3)
    val list2 = Nil
    list.size should equal(3)
    list2.size should equal(0)
  }

}
