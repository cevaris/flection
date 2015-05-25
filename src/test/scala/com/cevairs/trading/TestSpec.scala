package com.cevaris.trading

import org.scalatest._
import org.scalacheck._

abstract class TestSpec extends FlatSpec
    with Matchers
    with OptionValues
    with Inside
    with Inspectors {
  val rand = scala.util.Random
}
