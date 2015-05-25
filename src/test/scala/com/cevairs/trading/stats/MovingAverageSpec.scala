package com.cevaris.trading.stats

import com.cevaris.trading.models._

import com.cevaris.trading.TestSpec
import com.cevaris.trading.models.StockSpec._

class MovingAverageSpec extends TestSpec {
  import MovingAverage._

  "A Simple Moving Average" should "be 0.0 for empty stocks list" in {
    val example: List[Stock]= List()
    SimpleMovingAverage.calculate(10, example) should be (0.0)
  }

  it should "return expected result for 30 days" in {
    SimpleMovingAverage.calculate(10, genStocks) should be (85.95)
  }

  it should "return expected result for 178 days" in {
    SimpleMovingAverage.calculate(15, genStocks) should be (85.7)
  }

  it should "return expected result for 356 days" in {
    SimpleMovingAverage.calculate(30, genStocks) should be (84.95)
  }

  it should "return expected result uptrend" in {
    SimpleMovingAverage.trend(365, 30, genStocksUptrend) should be (Uptrend)
  }

  it should "return expected result dowtrend" in {
    SimpleMovingAverage.trend(365, 30, genStocksDowntrend) should be (Downtrend)
  }

  it should "return expected result flatline" in {
    SimpleMovingAverage.trend(365, 30, genStocksFlatline) should be (Flatline)
  }

}
