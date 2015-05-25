package com.cevaris.trading.stats

import com.cevaris.trading.TestSpec

class UtilsSpec extends TestSpec {

  "A Average" should "be 0.0 for empty lists" in {
    val example: List[Int]= List()
    Utils.average(example) should be (0.0)
  }

  it should "return expected result for Int list" in {
    val example = List(1,2,3,4,5)
    Utils.average(example) should be (3.0)
  }

  it should "return expected result for Double list" in {
    val example = List(1.0,2.0,3.0,4.0,5.0)
    Utils.average(example) should be (3.0)
  }

}
