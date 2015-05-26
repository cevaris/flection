package com.cevaris.trading.strategies

import com.cevaris.trading.TestSpec

class TradingSimulationSpec extends TestSpec {

  "A Default Simulation" should "be load stocks" in {
    val simulation = DefaultSimulation()
    println(simulation.stocksFromFile)
    // SimpleMovingAverage.calculate(10, example) should be (0.0)
  }

  // it should "return expected result for 20 days" in {
  //   SimpleMovingAverage.calculate(20, genStocks) should be (85.45 +- 0.01)
  // }




}
