package com.cevaris.trading.stats

import com.cevaris.trading.models._





trait MovingAverage {
  def calculate(days: Int, ls: Seq[Stock]): Double
}

object MovingAverage {

  trait Trend
  object Uptrend extends Trend
  object Downtrend extends Trend
  object Flatline extends Trend

}

object SimpleMovingAverage extends MovingAverage {
  import MovingAverage.{Downtrend, Flatline, Trend, Uptrend}

  def calculate(days: Int, ls: Seq[Stock]): Double =
    Utils.average(ls.takeRight(days) map (_.close.value))

  def trend(long: Int, short: Int, ls: Seq[Stock]): Trend = {
    val longMA = calculate(long, ls)
    val shortMA = calculate(short, ls)

    if (longMA > shortMA)
      Downtrend
    else if (longMA < shortMA)
      Uptrend
    else
      Flatline
  }

}
object ExponnentialMovingAverage extends MovingAverage {
  def calculate(days: Int, ls: Seq[Stock]): Double = ???

}
