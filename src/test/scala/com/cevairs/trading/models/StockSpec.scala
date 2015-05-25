package com.cevaris.trading.models

import com.cevaris.trading.TestSpec

import org.joda.time._

object StockSpec extends TestSpec {
  def genStock(base: Int, minusDays: Int, growth: Double): Stock = {
    val datetime = DateTime.now().minusDays(minusDays)
    Stock(datetime.toInstant, Price(base + ((minusDays.toDouble/10) * growth)))
  }

  val genStocksDowntrend = (0 until 365) map (i => genStock(50, i, -1.0))
  val genStocksUptrend = (0 until 365) map (i => genStock(50, i, 1.0))
  val genStocksFlatline = (0 until 365) map (i => genStock(50, i, 0.0))
  val genStocks = genStocksUptrend


}

class StockSpec extends TestSpec {

}
