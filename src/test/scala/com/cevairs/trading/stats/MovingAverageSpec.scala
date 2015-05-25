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

  it should "return expected result for 20 days" in {
    SimpleMovingAverage.calculate(20, genStocks) should be (85.45 +- 0.01)
  }

  it should "return expected result for 200 days" in {
    SimpleMovingAverage.calculate(200, genStocks) should be (76.45 +- 0.01)
  }

  it should "return expected result uptrend" in {
    SimpleMovingAverage.trend(200, 26, genStocksUptrend) should be (Uptrend)
  }

  it should "return expected result dowtrend" in {
    SimpleMovingAverage.trend(200, 26, genStocksDowntrend) should be (Downtrend)
  }

  it should "return expected result flatline" in {
    SimpleMovingAverage.trend(200, 26, genStocksFlatline) should be (Flatline)
  }

  "A Exponential Moving Average" should "be 0.0 for empty stocks list" in {
    val example: List[Stock]= List()
    ExponentialMovingAverage.calculate(10, example) should be (0.0)
  }

  it should "return expected result for 20 days" in {
    val actual = ExponentialMovingAverage.calculate(20, genStocks)
    actual should equal (85.72 +- 0.01)
  }

  it should "return expected result for 200 days" in {
    val actual = ExponentialMovingAverage.calculate(200, genStocks)
    actual should equal (79.15 +- 0.01)
  }


   it should "return expected result uptrend" in {
     val actual = ExponentialMovingAverage.trend(200, 20, genStocksUptrend)
     actual should be (Uptrend)
  }

  it should "return expected result dowtrend" in {
    val actual = ExponentialMovingAverage.trend(200, 20, genStocksDowntrend)
    actual should be (Downtrend)
  }

  it should "return expected result flatline" in {
    val actual = ExponentialMovingAverage.trend(200, 20, genStocksFlatline)
    actual should be (Downtrend)
  }

}
