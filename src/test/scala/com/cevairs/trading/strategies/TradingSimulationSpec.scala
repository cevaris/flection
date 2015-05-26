package com.cevaris.trading.strategies

import com.cevaris.trading.TestSpec

class TradingSimulationSpec extends TestSpec {

  "A Default Simulation" should "should load  all stocks" in {
    val simulation = DefaultSimulation()
    val actual = simulation.stocksFromFile
    actual.size should be (4811)
  }

  it should "should trade all days" in {
    val simulation = DefaultSimulation()
    println(simulation.trade)
  }




}
