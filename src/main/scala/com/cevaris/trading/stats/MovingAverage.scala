package com.cevaris.trading.stats

import com.cevaris.trading.models._
import scala.math.abs

trait MovingAverage {
  import MovingAverage._

  def calculate(days: Int, ls: Seq[Stock]): Double
  def trend(long: Int, short: Int, ls: Seq[Stock]): Trend = {
    val longMA = calculate(long, ls)
    val shortMA = calculate(short, ls)

    if (longMA > shortMA)
      Downtrend
    else if (abs(longMA - shortMA) < Utils.precision)
      Flatline
    else
      Uptrend
  }
}

object MovingAverage {

  trait Trend {
    def show: String
  }
  object Uptrend extends Trend {
    def show: String = "Uptrend"
  }
  object Downtrend extends Trend {
    def show: String = "Downtrend"
  }
  object Flatline extends Trend {
    def show: String = "Flatline"
  }

}

/**
  * Simple moving algorithm as defined
  * http://www.investopedia.com/terms/m/movingaverage.asp
  */
object SimpleMovingAverage extends MovingAverage {
  def calculate(days: Int, ls: Seq[Stock]): Double =
    Utils.average(ls.takeRight(days) map (_.close.value))

}

/**
  * Exponential Moving Average as defined
  * http://stackoverflow.com/questions/24705011/how-to-optimise-a-exponential-moving-average-algorithm-in-php
  */
object ExponentialMovingAverage extends MovingAverage {
  def calculate(days: Int, ls: Seq[Stock]): Double = {
    val k = 2.0 / (days + 1)
    ls.takeRight(days).foldLeft(SimpleMovingAverage.calculate(days, ls))(
      (last, s) => (1 - k) * last + k * s.close.value
    )
  }

}
