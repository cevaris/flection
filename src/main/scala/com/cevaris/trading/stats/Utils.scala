package com.cevaris.trading.stats


object Utils {
  import Numeric._
  import Numeric.Implicits._

  def precision = 0.0000001

  def average[T: Numeric](ls: Seq[T]): Double = {
    if (ls.isEmpty) 0.0 else (ls.sum.toDouble / ls.size)
  }
}
